package edu.wgu.d288_backend.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<ValidEnumValue, Enum<?>> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumValue constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Let @NotNull handle this
        }

        for (Enum<?> enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.equals(value)) {
                return true;
            }
        }

        return false;
    }
}