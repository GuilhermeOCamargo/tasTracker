package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.model.form.AtivosDevicesForm;
import br.com.tas.tracker.console.model.form.QuestionarioForm;
import br.com.tas.tracker.console.services.EmpresaService;
import br.com.tas.tracker.console.services.QuestionarioService;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionarioController {
    Logger logger = LoggerFactory.getLogger(QuestionarioController.class);
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private QuestionarioService questionarioService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/questionario/form", method = RequestMethod.GET)
    public String showQuestionario(Model model, HttpSession session,
                                   @ModelAttribute("questionarioForm") QuestionarioForm questionarioForm){
        prepareForm(model, questionarioForm);
        return "main";
    }
    @RequestMapping(value = "/questionario/answer/{id}")
    public String answerQuestionario(@PathVariable String id, RedirectAttributes redirectAttributes, Model model){
        Questionario questionario = null;
        try{
            questionario = questionarioService.findById(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            logger.error("Erro ao converter id para Long: "+ id);
        }
        if(questionario == null){
            model.addAttribute("css", "danger");
            model.addAttribute("mensagem", "Questionário não encontrado.");
            return "redirect:pending";
        }
        redirectAttributes.addFlashAttribute("questionarioForm", questionario.toForm());
        return "redirect:/questionario/form";
    }

    /**
     * Salva o usuário
     * */
    @RequestMapping(value = "/questionario/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("questionarioForm") @Valid QuestionarioForm questionarioForm, BindingResult result,
                         Model model, RedirectAttributes redirectAttributes){
        logger.info("Iniciando ação Save questionario");
        if(result.hasErrors()){
            logger.error("Erros encontrados: "+ result.getErrorCount());
            prepareForm(model, questionarioForm);
            return "main";
        }
        logger.info("Questionario validado");
        Questionario questionario = new Questionario(questionarioForm,
                empresaService.findById(questionarioForm.getEmpresaId()));
        try{
            if(questionarioService.save(questionario)){
                logger.info("Salvo com sucesso.");
                redirectAttributes.addFlashAttribute("css", "success");
                redirectAttributes.addFlashAttribute("mensagem", "Salvo com sucesso.");
                return "redirect:/dashboard/answered/item/"+questionario.getId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.error("Erro ao salvar questionário.");
        prepareForm(model, questionarioForm);
        model.addAttribute("css", "success");
        model.addAttribute("mensagem", "Erro ao salvar questionário.");
        return "main";
    }

    @RequestMapping(value = "/questionario/pending", method = RequestMethod.GET)
    public String showPending(Model model, HttpSession session, @ModelAttribute("css") String css,
                              @ModelAttribute("mensagem") String mensagem){
        preparePending(model, session);
        model.addAttribute("css", css);
        model.addAttribute("mensagem", mensagem);
        return "main";
    }

    private void prepareForm(Model model, QuestionarioForm questionarioForm){
        QuestionarioForm questionario = (questionarioForm == null ? new QuestionarioForm():questionarioForm);
       /* questionario.setAtivosDevicesForm((questionario.getAtivosDevicesForm() == null?
                new AtivosDevicesForm():questionario.getAtivosDevicesForm()));*/
        model.addAttribute("questionarioForm", questionario);
        model.addAttribute("urlBody", "questionario");
        model.addAttribute("pageTitle", "Questionário");
    }
    private void preparePending(Model model, HttpSession session){
        Usuario usuario = usuarioService.findByEmail(session.getAttribute("loggedUser").toString());
        List<Empresa> empresas = empresaService.findByUsuario(usuario);
        List<Questionario> questionariosPendentes = new ArrayList<>();
        for (Empresa empresa:empresas) {
            Questionario pendente = questionarioService.findByEmpresaPending(empresa);
            if(pendente != null){
                questionariosPendentes.add(pendente);
            }
        }
        model.addAttribute("questionarios",(questionariosPendentes.isEmpty()? null:questionariosPendentes));
        model.addAttribute("urlBody", "questionarioPending");
        model.addAttribute("pageTitle", "Questionário");
    }
}
