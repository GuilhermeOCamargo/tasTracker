package br.com.tas.tracker.console.controller;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.model.form.UsuarioForm;
import br.com.tas.tracker.console.services.PermissaoService;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author guilherme.camargo
 * @since 20/09/2018
 * @version 1.0
 * */
@Controller

public class UsuarioController {

    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService userService;
    @Autowired
    private PermissaoService permissaoService;

    /**
     * @return Página com a lista de usuários
     * */
    @RequestMapping(value = "/usuario/list", method = RequestMethod.GET)
    public String showFormUsuario(UsuarioForm usuarioForm, Model model, @ModelAttribute("css") String css,
                                  @ModelAttribute("mensagem") String mensagem, HttpSession session) {
        prepareList(model, session);
        prepareForm(model, usuarioForm);
        model.addAttribute("css", css);
        model.addAttribute("mensagem", mensagem);
        return "main";
    }
    /**
     * Salva o usuário
     * */
    @RequestMapping(value = "/usuario/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("usuarioForm") @Valid UsuarioForm usuarioForm, BindingResult result,
                         Model model, RedirectAttributes redirectAttributes, HttpSession session){
        logger.info("Iniciando ação saveUsuario");
        if(result.hasErrors()){
            logger.error("Erros encontrados: "+ result.getErrorCount());
            prepareList(model, session);
            prepareForm(model, usuarioForm);
            return "main";
        }
        try{
            Usuario usuario = usuarioForm.build(permissaoService.findById(usuarioForm.getPermissaoId()));
            if(userService.save(usuario)){
                logger.info("Salvo com sucesso.");
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("mensagem", "Salvo com sucesso.");
                return "redirect:list";
            }
        }catch (Exception e){
        }
        prepareList(model, session);
        prepareForm(model, usuarioForm);
        model.addAttribute("css", "danger");
        model.addAttribute("mensagem", "Erro ao salvar.");
        return "main";
    }
    /**
     * Prepara o usuário para ser editado
     * */
    @RequestMapping(value = "/usuario/edit/{id}", method = RequestMethod.GET)
    public String prepareEdit(@PathVariable String id, Model model, HttpSession session){
        Usuario usuario = null;
        try{
            usuario = userService.findById(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            logger.error("Erro ao converter id para Long: "+ id);
        }

        if(usuario == null){
            model.addAttribute("css", "error");
            model.addAttribute("mensagem", "Usuário não encontrado.");
            return "redirect:list";
        }
        prepareForm(model, usuario.toForm());
        prepareList(model, session);
        return "main";
    }
    /**
     * Chama o modal de confirmação de deleção
     * */
    @RequestMapping(value = "/usuario/confirmDel/{id}", method = RequestMethod.GET)
    public String showModalConfirmDel(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Usuario usuario = userService.findById(id);
        if(usuario == null){
            redirectAttributes.addFlashAttribute("css", "error");
            redirectAttributes.addFlashAttribute("mensagem", "Usuário não encontrado.");
            return "redirect:/usuario/list";
        }
        model.addAttribute("modalTitle", "Deseja deletar o usuário abaixo?");
        model.addAttribute("cssButton", "danger");
        model.addAttribute("linkConfirm", "/usuario/delete/"+id);
        model.addAttribute("userToDelete", usuario);
        return "Modal/modalConfirm";
    }
    /**
     * Deleta o usuário
     * */
    @RequestMapping(value = "/usuario/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        if(!userService.deleteById(id)){
            redirectAttributes.addFlashAttribute("css", "error");
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao deletar.");
            return "redirect:/usuario/list";
        }else{
            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("mensagem", "Usuário deletado com sucesso.");
            return "redirect:/usuario/list";
        }
    }
    /**
     * Prepara o form de usuários
     * */
    private void prepareForm(Model model, UsuarioForm usuarioForm){
        model.addAttribute("usuarioForm", (usuarioForm == null ? new UsuarioForm():usuarioForm));
        model.addAttribute("permissoes", permissaoService.findAll());

    }
    /**
     * Prepara a lista de usuários
     * */
    private void prepareList(Model model, HttpSession session){
        model.addAttribute("usuarios", userService.findAllExceptLogged(
                session.getAttribute("loggedUser").toString()));
        model.addAttribute("urlBody", "usuario");
        model.addAttribute("pageTitle", "Usuários");
    }
}
