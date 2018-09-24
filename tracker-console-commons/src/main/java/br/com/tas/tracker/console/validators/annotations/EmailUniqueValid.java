package br.com.tas.tracker.console.validators.annotations;

import br.com.tas.tracker.console.validators.impl.EmailUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author guilherme.camargo
 * @since 23/09/2018
 * @version 1.0
 * */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
public @interface EmailUniqueValid {
    String message()default ""/*"E-mail Cadastrado."*/;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    String value() default "";
}
