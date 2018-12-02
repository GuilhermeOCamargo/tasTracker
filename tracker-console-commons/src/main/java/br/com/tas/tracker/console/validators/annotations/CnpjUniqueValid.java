package br.com.tas.tracker.console.validators.annotations;

import br.com.tas.tracker.console.validators.impl.CnpjUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author guilherme.camargo
 * @since 11/10/2018
 * @version 1.0
 * */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CnpjUniqueValidator.class)
public @interface CnpjUniqueValid {
    String message()default "Cnpj já Cadastrado.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    String cnpj() default "";
    String id() default "";
}
