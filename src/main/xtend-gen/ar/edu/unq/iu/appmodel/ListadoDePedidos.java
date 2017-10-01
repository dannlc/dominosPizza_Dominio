package ar.edu.unq.iu.appmodel;

import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.repo.RepoPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.utils.ObservableUtils;

@Observable
@Accessors
@SuppressWarnings("all")
public class ListadoDePedidos implements Serializable {
  private Pedido pedidoSeleccionado;
  
  public void cancelarPedido() {
    Cancelado _cancelado = new Cancelado();
    this.pedidoSeleccionado.setEstado(_cancelado);
  }
  
  public List<Pedido> getPedidosAbiertos() {
    return this.getRepoPedido().getPedidosAbiertos();
  }
  
  public RepoPedido getRepoPedido() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pedido.class);
    return ((RepoPedido) _singleton);
  }
  
  public ArrayList<Pedido> getPedidosCerrados() {
    return this.getRepoPedido().getPedidosCerrados();
  }
  
  public void actualizar() {
    ObservableUtils.firePropertyChanged(this, "pedidosAbiertos");
  }
  
  public void pasarAEstadoSiguiente() {
    this.pedidoSeleccionado.pasarAlSiguienteEstado();
    this.actualizar();
  }
  
  public void pasarAEstadoAnterior() {
    this.pedidoSeleccionado.pasarAlEstadoAnterior();
    this.actualizar();
  }
  
  @Pure
  public Pedido getPedidoSeleccionado() {
    return this.pedidoSeleccionado;
  }
  
  public void setPedidoSeleccionado(final Pedido pedidoSeleccionado) {
    this.pedidoSeleccionado = pedidoSeleccionado;
  }
}
