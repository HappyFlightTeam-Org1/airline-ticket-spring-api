package com.fsoft.happflight.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsoft.happflight.services.nguoi_dung.INguoiDungService;

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
