package edu.wgu.d288_backend.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnumValue {
    String message() default "Invalid value. Allowed values are {enumClass.simpleName}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<? extends Enum<?>> enumClass(); // Specify the enum class
}