package br.com.tas.tracker.console;

import br.com.tas.tracker.console.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guilherme.camargo
 * @since 20/09/2018
 * @version 1.0
 * */
@RestController
public class UsuarioRestController {

    @Autowired
    private UsuarioService userService;
    /*@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
    public ResponseEntity submit(@ModelAttribute("usuario") UsuarioDto usuario, @Validated BindingResult result){
        try{
            if(userService.save(usuario)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
