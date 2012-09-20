package br.com.unifacs.dao;

public class DaoException extends Exception {

	private Exception exceptionOriginal;

	public DaoException(Exception ex) {
		this.exceptionOriginal = ex;
	}
	
	public Exception getExceptionOriginal() {
		return exceptionOriginal;
	}
}
