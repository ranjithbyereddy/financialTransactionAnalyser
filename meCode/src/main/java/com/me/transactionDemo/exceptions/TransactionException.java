package com.me.transactionDemo.exceptions;

@SuppressWarnings("serial")
public class TransactionException extends RuntimeException {
	public TransactionException(String message) {
		super(message);
	}
}
