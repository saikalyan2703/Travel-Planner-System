package com.spring.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadReq extends RuntimeException{

	private static final long serialVersionUID = -2641754335553375876L;
	
	public BadReq(String msg) {
		super(msg);
	}
	
	public BadReq(String msg,Throwable cause) {
		super(msg,cause);
	}
	

}
