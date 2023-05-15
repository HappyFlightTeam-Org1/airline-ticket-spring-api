package com.fsoft.happflight.utils;

import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailExitsValidator implements ConstraintValidator<CheckEmailExitsConstraint, String> {
    @Autowired
    private INguoiDungService nguoiDungService;

    @Override
    public void initialize(CheckEmailExitsConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return true;
    }
}
