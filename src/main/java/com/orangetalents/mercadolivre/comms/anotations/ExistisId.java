package br.com.zupacademy.alana.casadocodigo.validators.AnotacoesPersonalizadas;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ExistIdValidator.class})
public @interface ExistisId {
    String message() default "Não existe registro com esse campo de identificação";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    Class<?> classe();
}
