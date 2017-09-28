package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.Pedido;
import com.google.common.base.Objects;
import java.util.List;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@SuppressWarnings("all")
public abstract class EstadoPedido extends Entity {
  public List<EstadoPedido> posiblesEstados(final Pedido p) {
    return null;
  }
  
  public EstadoPedido estadoSiguiente(final Envio envio) {
    return null;
  }
  
  public EstadoPedido estadoAnterior(final Envio envio) {
    return null;
  }
  
  @Override
  public boolean equals(final Object o) {
    Class<? extends EstadoPedido> _class = this.getClass();
    Class<?> _class_1 = o.getClass();
    return Objects.equal(_class, _class_1);
  }
  
  public abstract Boolean esAbierto();
  
  public abstract String nombre();
  
  @Override
  public String toString() {
    return this.nombre();
  }
}
