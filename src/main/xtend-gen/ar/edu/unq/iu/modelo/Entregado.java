package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.ListoParaRetirar;
import ar.edu.unq.iu.modelo.Retirar;
import com.google.common.base.Objects;

@SuppressWarnings("all")
public class Entregado extends EstadoPedido {
  public Entregado() {
  }
  
  @Override
  public String nombre() {
    return "Entregado";
  }
  
  @Override
  public EstadoPedido estadoAnterior(final Envio e) {
    Retirar _retirar = new Retirar();
    boolean _equals = Objects.equal(e, _retirar);
    if (_equals) {
      return new ListoParaRetirar();
    } else {
      return new EnViaje();
    }
  }
  
  @Override
  public Boolean esAbierto() {
    return Boolean.valueOf(false);
  }
  
  @Override
  public String toString() {
    return this.nombre();
  }
}
