package com.fsoft.happflight.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsoft.happflight.services.chuyen_bay.IChuyenBayService;

public class CheckDuplicateMaChuyenBay implements ConstraintValidator<CheckMaChuyenBay, String> {
	@Autowired
	IChuyenBayService chuyenBayService;

	@Override
	public void initialize(CheckMaChuyenBay constraintAnnotation) {
	}
//Tự động được gọi
	@Override
	public boolean isValid(String maChuyenBay, ConstraintValidatorContext context) {
		if (chuyenBayService.findById(maChuyenBay) != null) {
			return false;
		} else {
			return true;
		}
	}
	

}