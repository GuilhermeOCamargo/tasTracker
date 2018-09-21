package br.com.tas.tracker.console.validators;

import br.com.tas.tracker.console.Util.MessageUtil;
import br.com.tas.tracker.console.enums.ResourceBundles;
import br.com.tas.tracker.console.exceptions.*;
import br.com.tas.tracker.console.model.Usuario;
import br.com.tas.tracker.console.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UsuarioValidator implements Validator {
    private static final Logger log = LoggerFactory.getLogger(UsuarioValidator.class);

    @Autowired
    private UsuarioService userService;

    private String getPropertieMessage(String key){
        return MessageUtil.loadProperties(ResourceBundles.MESSAGES.getDesc()).getProperty(key);
    }
    @Override
    public boolean supports(Class candidate) {
        return Usuario.class.isAssignableFrom(candidate);
    }

    @Override
    public void validate(Object o, Errors errors) {
        log.info("Validando todos os campos do usuário");
        Usuario usuario = (Usuario) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome",getPropertieMessage("error.user.validation.nome.null"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", getPropertieMessage("error.user.validation.email.null"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha",getPropertieMessage("error.user.validation.senha.null"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "permissao", getPropertieMessage("error.user.validation.permissao.null"));

        if(usuario.getNome().length() > 100){
            log.error("Validação nome chars - falhou");
            errors.rejectValue("nome", getPropertieMessage("error.user.validation.nome.chars"));
        }
        if(usuario.getEmail().length() > 50){
            log.error("Validação email chars - falhou");
            errors.rejectValue("email", getPropertieMessage("error.user.validation.nome.chars"));
        }
        if(userService.findByEmail(usuario.getEmail()) != null){
            log.error("Validação email unique - falhou");
            errors.rejectValue("email", getPropertieMessage("error.user.validation.email.unique"));
        }
        if(usuario.getSenha().length() > 15 || usuario.getSenha().length() < 8){
            log.error("Validação senha chars - falhou");
            errors.rejectValue("senha", getPropertieMessage("error.user.validation.senha.chars"));
        }
        if(usuario.getPermissao() == null){
            log.error("Validação permissão null - falhou");
            errors.rejectValue("permissao", getPropertieMessage("error.user.validation.permissao.null"));
        }
    }
}
