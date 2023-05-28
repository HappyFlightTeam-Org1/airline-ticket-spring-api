package com.fsoft.happflight.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDuplicateMaChuyenBay.class)
//Đặt tên interface này lên trên đầu của field muốn sử dụng
public @interface CheckMaChuyenBay {
	String message() default " Mã chuyến bay  đã tồn tại!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}