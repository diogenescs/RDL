package br.com.unifacs.bo;

public class BoException extends Exception {

	private Exception exceptionOriginal;

	public BoException(Exception ex, String msg) {
		super(msg);
		this.exceptionOriginal = ex;
	}
	
	public Exception getExceptionOriginal() {
		return exceptionOriginal;
	}
}
