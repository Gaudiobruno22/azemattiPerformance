package br.com.azematti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RequiredObjectException(String msg) {
		super(msg);
	}
	
	public RequiredObjectException() {
		super("Não é possível Solicitar um Cadastro. Valores estão Nulos!");
	}
}
