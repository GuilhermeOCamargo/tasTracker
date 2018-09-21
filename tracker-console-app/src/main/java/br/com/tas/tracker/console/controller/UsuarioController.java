package br.com.tas.tracker.console.controller;

import br.com.tas.tracker.console.model.Usuario;
import br.com.tas.tracker.console.services.UsuarioService;
import br.com.tas.tracker.console.validators.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author guilherme.camargo
 * @since 20/09/2018
 * @version 1.0
 * */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioValidator userValidator;
    @Autowired
    private UsuarioService userService;
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(userValidator);
    }
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ModelAndView showFormUsuario(){
        ModelAndView model = new ModelAndView("usuario");
        model.addObject("usuario", new Usuario());
        return model;
    }
    @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("usuario") @Validated  Usuario usuario, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("usuario");
            return model;
        }
        return new ModelAndView("erro404");
        /*try{
            if(userService.save(usuario)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
    }

}
