package com.enigma.reimbursment.online.models.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        return t == null || t.matches("[A-Za-z]*");
    }
}
