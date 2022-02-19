package br.com.nagata.dev.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends Exception {

  private static final long serialVersionUID = 1L;
  private final HttpStatus code;

  public BusinessException(String message) {
    super(message);
    this.code = null;
  }

  public BusinessException(HttpStatus code, String message) {
    super(message);
    this.code = code;
  }

  public BusinessException(String message, Throwable throwable) {
    super(message, throwable);
    this.code = null;
  }

  public BusinessException(HttpStatus code, String message, Throwable throwable) {
    super(message, throwable);
    this.code = code;
  }
}
