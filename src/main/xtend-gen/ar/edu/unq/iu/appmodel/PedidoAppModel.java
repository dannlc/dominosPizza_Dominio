package ar.edu.unq.iu.appmodel;

import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.TamanioGrande;
import ar.edu.unq.iu.repo.RepoPizza;
import java.io.Serializable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class PedidoAppModel implements Serializable {
  private Plato platoSeleccionado;
  
  private Pedido pedido;
  
  public PedidoAppModel(final Pedido pedido) {
    this.pedido = pedido;
  }
  
  public boolean eliminarPlato() {
    return this.pedido.getPlatos().remove(this.platoSeleccionado);
  }
  
  public Plato getNuevoPlato() {
    Pizza _get = this.getRepoPizza().getObjects().get(0);
    TamanioGrande _tamanioGrande = new TamanioGrande();
    return new Plato(_get, _tamanioGrande);
  }
  
  public RepoPizza getRepoPizza() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pizza.class);
    return ((RepoPizza) _singleton);
  }
  
  @Pure
  public Plato getPlatoSeleccionado() {
    return this.platoSeleccionado;
  }
  
  public void setPlatoSeleccionado(final Plato platoSeleccionado) {
    this.platoSeleccionado = platoSeleccionado;
  }
  
  @Pure
  public Pedido getPedido() {
    return this.pedido;
  }
  
  public void setPedido(final Pedido pedido) {
    this.pedido = pedido;
  }
}
