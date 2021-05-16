package co.gov.mme.usuario.exception;

import lombok.Data;

@Data
public class UsuarioException extends Exception {

	private int code;

	public UsuarioException(String message) {
		super(message);
	}

	public UsuarioException(String message, int code) {
		super(message);
		this.code = code;
	}

	public UsuarioException(String message, Throwable cause) {
		super(message, cause);
	}
}
