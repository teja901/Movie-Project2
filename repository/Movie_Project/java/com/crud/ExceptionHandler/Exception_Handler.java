package com.crud.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.ExceptionMessages.UserNotFound;

@RestControllerAdvice
public class Exception_Handler {

	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFound.class)
	public Map<String,String> getException(UserNotFound un){
		
		Map<String, String> error=new HashMap<>();
		 error.put("please check",un.getMessage());
		 return error;
	}
	
}
