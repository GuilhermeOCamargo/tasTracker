package br.com.tas.tracker.console.validators.impl;

import br.com.tas.tracker.console.services.UsuarioService;
import br.com.tas.tracker.console.validators.annotations.EmailUniqueValid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * @author guilherme.camargo
 * @since 23/09/2018
 * @version 1.0
 * */
public class EmailUniqueValidator implements ConstraintValidator<EmailUniqueValid, String> {

    @Autowired
    private UsuarioService usuarioService;
    private String value;

    @Override
    public void initialize(EmailUniqueValid constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(usuarioService.findByEmail(value) != null){
            return false;
        }
        return true;
    }
}
