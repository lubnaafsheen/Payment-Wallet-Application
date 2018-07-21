package com.capgemini.walletapplication.exception;

public class MinTransferAmountException extends Throwable {

	private String string;

	public MinTransferAmountException(String string) {
		// TODO Auto-generated constructor stub
		this.string = string;

	}

	private static final long serialVersionUID = 1L;

}
