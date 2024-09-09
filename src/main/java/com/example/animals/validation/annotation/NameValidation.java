package com.example.animals.validation.annotation;

import com.example.animals.validation.impl.NameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameValidation {

    // error message
    public String message() default "Invalid name: must be PIMPEK or DINGO";

    // represents group of constaints
    public Class<?>[] groups() default {};

    // represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
