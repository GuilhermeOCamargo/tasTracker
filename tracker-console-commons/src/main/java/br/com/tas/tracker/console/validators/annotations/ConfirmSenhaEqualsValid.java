package br.com.tas.tracker.console.validators.annotations;

import br.com.tas.tracker.console.validators.impl.ConfirmSenhaEqualsValidator;

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
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmSenhaEqualsValidator.class)
public @interface ConfirmSenhaEqualsValid {
    String message()default "O campo nao corresponde com a senha informada.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    String senha() default "";
    String confirmSenha() default "";

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        ConfirmSenhaEqualsValid[] value();
    }

}
