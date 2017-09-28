package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.ListoParaEnviar;
import ar.edu.unq.iu.modelo.ListoParaRetirar;
import ar.edu.unq.iu.modelo.Retirar;
import com.google.common.base.Objects;

@SuppressWarnings("all")
public class Preparando extends EstadoPedido {
  public Preparando() {
  }
  
  @Override
  public EstadoPedido estadoSiguiente(final Envio e) {
    Retirar _retirar = new Retirar();
    boolean _equals = Objects.equal(e, _retirar);
    if (_equals) {
      return new ListoParaRetirar();
    } else {
      return new ListoParaEnviar();
    }
  }
  
  @Override
  public Boolean esAbierto() {
    return Boolean.valueOf(true);
  }
  
  @Override
  public String nombre() {
    return "Preparando";
  }
}
