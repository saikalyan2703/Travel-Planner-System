package com.spring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class EntityExcep extends RuntimeException{

	
	private static final long serialVersionUID = -6836527819949421667L;
	
	public  EntityExcep(String msg) { 
		super(msg);
	}
	
	public  EntityExcep(String msg,Throwable cause) { 
		super(msg,cause);
	}
}
