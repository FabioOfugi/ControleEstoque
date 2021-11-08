package com.inf.ufg.exceptions;

public class ElementoNaoEncontradoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementoNaoEncontradoException(final String msg) {
		super(msg);	
	}
}
