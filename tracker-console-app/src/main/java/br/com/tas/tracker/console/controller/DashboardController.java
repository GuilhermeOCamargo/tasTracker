package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.dto.Empresa;
import br.com.tas.tracker.console.model.dto.Questionario;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.services.EmpresaService;
import br.com.tas.tracker.console.services.QuestionarioService;
import br.com.tas.tracker.console.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author guilherme.camargo
 * @since 17/10/2018
 * @version 1.0
 * */
@Controller
public class DashboardController {
    Logger logger = LoggerFactory.getLogger(DashboardController.class);
    @Autowired
    private QuestionarioService questionarioService;
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/dashboard/list")
    public String showDashboardList(Model model, HttpSession session, @ModelAttribute("css") String css,
                                    @ModelAttribute("mensagem") String mensagem){
        prepareList(model, session);
        model.addAttribute("css", css);
        model.addAttribute("mensagem", mensagem);
        return "main";
    }

    @RequestMapping(value = "/dashboard/answered/list/{id}")
    public String showAnswered(@PathVariable String id, Model model, RedirectAttributes redirectAttributes,
                               HttpSession session){
        Empresa empresa = null;
        try{
             empresa = empresaService.findById(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao carregar questionários");
            return "redirect:/dashboard/list";
        }
        prepareAnswered(model, empresa);
        return "main";
    }
    @RequestMapping(value = "/dashboard/answered/item/{id}")
    public String showAnsweredItem(@PathVariable String id, Model model, RedirectAttributes redirectAttributes){
        Questionario questionario = null;
        try{
            questionario = questionarioService.findById(Long.parseLong(id));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao carregar questionário");
            return "redirect:/dashboard/list";
        }
        prepareAnsweredItem(model);
        model.addAttribute("questionario", questionario);
        return "main";
    }

    private void prepareAnsweredItem(Model model){
        model.addAttribute("urlBody", "dashboard");
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("urlList", "Lists/listRespQuestionario");
    }
    private void prepareAnswered(Model model, Empresa empresa){
        model.addAttribute("questionarios", questionarioService.findByEmpresaAnswered(empresa));
        model.addAttribute("urlBody", "dashboard");
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("urlList", "Lists/listQuestionarioDashboard");
    }

    private void prepareList(Model model, HttpSession session){
        Usuario usuario = usuarioService.findByEmail(session.getAttribute("loggedUser").toString());
        List<Empresa> empresas;
        if(usuario.getPermissao().getNome().toLowerCase().equals("empresa")){
            empresas = empresaService.findByUsuario(usuario);
        }else{
            empresas = empresaService.findAll();
        }
        model.addAttribute("empresas", empresas);
        model.addAttribute("urlBody", "dashboard");
        model.addAttribute("pageTitle", "Dashboard");
        model.addAttribute("urlList", "Lists/listEmpresaDashboard");
    }
}
