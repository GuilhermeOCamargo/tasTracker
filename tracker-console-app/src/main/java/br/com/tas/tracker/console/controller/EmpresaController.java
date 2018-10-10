package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.form.EmpresaForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpresaController {

    @RequestMapping(value = "/empresa/list", method = RequestMethod.GET)
    public String showEmpresaList(Model model){
        prepareForm(model, null);
        return "main";
    }

    private void prepareForm(Model model, EmpresaForm empresaForm){
        model.addAttribute("urlBody", "empresa");
        model.addAttribute("empresa", (empresaForm == null ? new EmpresaForm() : empresaForm));

    }
}
