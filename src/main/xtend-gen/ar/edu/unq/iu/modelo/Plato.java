package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Agregado;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Tamanio;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class Plato {
  private Pizza pizza;
  
  private Tamanio tamanio;
  
  private List<Agregado> agregados = new ArrayList<Agregado>();
  
  public Plato(final Pizza p, final Tamanio tamanio) {
    this.pizza = p;
    this.tamanio = tamanio;
  }
  
  public double getPrecio() {
    double _xblockexpression = (double) 0;
    {
      double _precio = this.pizza.getPrecio();
      double _precio_1 = this.tamanio.getPrecio();
      double p = (_precio * _precio_1);
      for (final Agregado a : this.agregados) {
        double _p = p;
        Double _precio_2 = a.getPrecio();
        p = (_p + (_precio_2).doubleValue());
      }
      _xblockexpression = p;
    }
    return _xblockexpression;
  }
  
  @Pure
  public Pizza getPizza() {
    return this.pizza;
  }
  
  public void setPizza(final Pizza pizza) {
    this.pizza = pizza;
  }
  
  @Pure
  public Tamanio getTamanio() {
    return this.tamanio;
  }
  
  public void setTamanio(final Tamanio tamanio) {
    this.tamanio = tamanio;
  }
  
  @Pure
  public List<Agregado> getAgregados() {
    return this.agregados;
  }
  
  public void setAgregados(final List<Agregado> agregados) {
    this.agregados = agregados;
  }
}
