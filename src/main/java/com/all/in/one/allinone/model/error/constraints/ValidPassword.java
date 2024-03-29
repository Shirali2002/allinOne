package com.all.in.one.allinone.model.error.constraints;



import com.all.in.one.allinone.model.error.ErrorMessages;
import com.all.in.one.allinone.model.error.constraints.validator.PasswordConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default ErrorMessages.INVALID_PASSWORD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}