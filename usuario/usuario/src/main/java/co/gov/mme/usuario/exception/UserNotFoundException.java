package co.gov.mme.usuario.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends Exception{

  private int code;

  public UserNotFoundException(String message, int code) {
    super(message);
    this.code = code;
  }

}
