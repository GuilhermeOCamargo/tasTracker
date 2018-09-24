package br.com.tas.tracker.console.controller;
import br.com.tas.tracker.console.model.dto.Usuario;
import br.com.tas.tracker.console.model.form.UsuarioForm;
import br.com.tas.tracker.console.services.PermissaoService;
import br.com.tas.tracker.console.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ModelAndView showFormUsuario(UsuarioForm usuarioForm){
        ModelAndView model = new ModelAndView("usuario");
        model.addObject("usuarioForm", (usuarioForm == null ? new UsuarioForm():usuarioForm));
        model.addObject("usuarios", userService.findAll());
        model.addObject("permissoes", permissaoService.findAll());
        return model;
    }
    @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("usuarioForm") @Valid UsuarioForm usuarioForm, BindingResult result){
        logger.info("Iniciando ação saveUsuario");
        if(result.hasErrors()){
            return showFormUsuario(usuarioForm);
        }
        try{
            Usuario usuario = usuarioForm.build(permissaoService.findById(usuarioForm.getPermissao()));
            if(userService.save(usuario)){
                return showFormUsuario(new UsuarioForm());
            }
            return new ModelAndView("erro404");
        }catch (Exception e){
            return new ModelAndView("erro404");
        }


    }
}
