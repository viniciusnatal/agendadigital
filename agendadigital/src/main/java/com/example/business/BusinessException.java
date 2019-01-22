package com.example.business;

//Dispara quando o nome nao for informado
public class BusinessException extends Exception {

	public BusinessException(String message) {
		super(message);

	}

}
