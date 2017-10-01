package ar.edu.unq.iu.modelo;

import org.uqbar.commons.model.exceptions.UserException;

@SuppressWarnings("all")
public class CambioDeEstadoException extends UserException {
  public CambioDeEstadoException(final String message) {
    super(message);
  }
}
