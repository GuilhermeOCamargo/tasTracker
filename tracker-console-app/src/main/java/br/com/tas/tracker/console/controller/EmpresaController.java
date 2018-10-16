package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.model.form.EmpresaForm;
import br.com.tas.tracker.console.services.EmpresaService;
import br.com.tas.tracker.console.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
/**
 * @author guilherme.camargo
 * @since 10/10/2018
 * @version 1.0
 * */
@Controller
public class EmpresaController {
    private final Logger logger = LoggerFactory.getLogger(EmpresaController.class);

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmpresaService empresaService;
    /**
     * Redireciona para a lista de empresas e formulário
     * */
    @RequestMapping(value = "/empresa/list", method = RequestMethod.GET)
    public String showEmpresaList(Model model, @ModelAttribute("css") String css, @ModelAttribute("mensagem") String mensagem){
        prepareList(model);
        prepareForm(model, null);
        model.addAttribute("css", css);
        model.addAttribute("mensagem", mensagem);
        return "main";
    }
    /**
     * Insere ou altera uma empresa
     * */
    @RequestMapping(value = "/empresa/save", method = RequestMethod.POST)
    public String saveEmpresa(@ModelAttribute("empresaForm")@Valid EmpresaForm empresaForm, BindingResult result,
                              Model model, RedirectAttributes redirectAttributes){
        logger.info("Iniciando ação Salvar empresa");
        if(result.hasErrors()){
            logger.error("Erros encontrados: "+ result.getErrorCount());
            prepareForm(model, empresaForm);
            prepareList(model);
            return "main";
        }
        logger.info("Validação OK");
        Usuario usuario = usuarioService.findById(empresaForm.getUsuarioId());
        Empresa empresa = empresaForm.build(usuario);
        if(empresaService.save(empresa)){
            logger.info("Salvo com sucesso.");
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("mensagem", "Salvo com sucesso.");
            return "redirect:list";
        }
        logger.info("Erro ao salvar empresa.");
        prepareList(model);
        prepareForm(model, empresaForm);
        model.addAttribute("css", "danger");
        model.addAttribute("mensagem", "Erro ao salvar.");
        return "main";
    }
    /**
     * Prepara para a edição da empresa
     * */
    @RequestMapping(value = "/empresa/edit/{id}", method = RequestMethod.GET)
    public String prepareEdit(@PathVariable String id, Model model){
        Empresa empresa = null;
        try{
            empresa = empresaService.findById(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            logger.error("Erro ao converter id para Long: "+ id);
        }
        if(empresa == null){
            model.addAttribute("css", "error");
            model.addAttribute("mensagem", "Empresa não encontrada.");
            return "redirect:list";
        }
        prepareForm(model, empresa.toForm());
        prepareList(model);
        return "main";
    }
    /**
     * Chama o modal de confirmação de deleção
     * */
    @RequestMapping(value = "/empresa/confirmDel/{id}", method = RequestMethod.GET)
    public String showModalConfirmDel(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Empresa empresa = empresaService.findById(id);
        if(empresa == null){
            redirectAttributes.addFlashAttribute("css", "error");
            redirectAttributes.addFlashAttribute("mensagem", "Empresa não encontrada.");
            return "redirect:/empresa/list";
        }
        model.addAttribute("modalTitle", "Deseja deletar a empresa abaixo?");
        model.addAttribute("cssButton", "danger");
        model.addAttribute("linkConfirm", "/empresa/delete/"+id);
        model.addAttribute("empresaToDelete", empresa);
        return "Modal/modalConfirmEmpresa";
    }
    /**
     * Deleta a empresa
     * */
    @RequestMapping(value = "/empresa/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        if(!empresaService.deleteById(id)){
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao deletar.");
            return "redirect:/empresa/list";
        }else{
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("mensagem", "Empresa deletada com sucesso.");
            return "redirect:/empresa/list";
        }
    }

    @RequestMapping(value = "/empresa/createQuestionario/{id}")
    public String createQuestionario(@PathVariable String id, RedirectAttributes redirectAttributes){
        Boolean isCriado = true;
        try{
            isCriado = empresaService.createQuestionario(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            logger.error("Erro ao converter para Long: "+id);
            isCriado = false;
        }
        if(!isCriado){
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao criar questionário.");
        }else{
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("mensagem", "Questionário criado com sucesso.");
        }
        return "redirect:/empresa/list";
    }

    /**
     * Prepara o formulário
     * */
    private void prepareForm(Model model, EmpresaForm empresaForm){
        model.addAttribute("empresaForm", (empresaForm == null ? new EmpresaForm() : empresaForm));
        model.addAttribute("usuarios", usuarioService.findAllEmpresas());
    }
    /**
     * Prepara a lista
     * */
    private void prepareList(Model model){
        model.addAttribute("empresas", empresaService.findAll());
        model.addAttribute("urlBody", "empresa");
        model.addAttribute("pageTitle", "Empresas");
    }
}
