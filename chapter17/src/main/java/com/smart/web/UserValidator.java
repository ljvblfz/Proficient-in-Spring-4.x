package com.smart.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.smart.domain.User;

public class UserValidator implements Validator {
	private static String[] reservedUserNames = { "aaaa", "bbbb" };
	private static List<String> reservedUserNameList = Arrays
			.asList(reservedUserNames);

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		if (target instanceof User) {
			User user = (User) target;
			if (reservedUserNameList.contains(user.getUserName())) {
				errors.rejectValue("userName", "reserved");
			}
		}
	}
}
