package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.form.AtivosDevicesForm;
import br.com.tas.tracker.console.model.form.QuestionarioForm;
import br.com.tas.tracker.console.services.EmpresaService;
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
@Controller
public class QuestionarioController {
    Logger logger = LoggerFactory.getLogger(QuestionarioController.class);
    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(value = "/questionario/form", method = RequestMethod.GET)
    public String showQuestionario(Model model, HttpSession session){
        prepareForm(model, null);
        return "main";
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
        return "redirect:form";
    }

    private void prepareForm(Model model, QuestionarioForm questionarioForm){
        QuestionarioForm questionario = (questionarioForm == null ? new QuestionarioForm():questionarioForm);
       /* questionario.setAtivosDevicesForm((questionario.getAtivosDevicesForm() == null?
                new AtivosDevicesForm():questionario.getAtivosDevicesForm()));*/
        model.addAttribute("questionarioForm", questionario);
        model.addAttribute("urlBody", "questionario");
        model.addAttribute("pageTitle", "Questionário");

    }
}
