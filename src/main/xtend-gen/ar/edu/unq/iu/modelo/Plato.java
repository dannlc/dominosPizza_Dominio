package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Agregado;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Tamanio;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class Plato {
  private Pizza pizza;
  
  private Tamanio tamanio;
  
  private Map<Ingrediente, Agregado> agregados = new HashMap<Ingrediente, Agregado>();
  
  public Plato(final Pizza p, final Tamanio tamanio) {
    this.pizza = p;
    this.tamanio = tamanio;
  }
  
  @Dependencies({ "agregados", "pizza", "tamanio" })
  public double getPrecio() {
    double _xblockexpression = (double) 0;
    {
      double _precio = this.pizza.getPrecio();
      double _precio_1 = this.tamanio.getPrecio();
      double p = (_precio * _precio_1);
      Collection<Agregado> _values = this.agregados.values();
      for (final Agregado a : _values) {
        double _p = p;
        Double _precio_2 = a.getPrecio();
        p = (_p + (_precio_2).doubleValue());
      }
      _xblockexpression = p;
    }
    return _xblockexpression;
  }
  
  public Agregado agregarAgregado(final Agregado a) {
    return this.agregados.put(a.getIngrediente(), a);
  }
  
  public Agregado quitarAgregado(final Agregado a) {
    return this.agregados.remove(a.getIngrediente());
  }
  
  public boolean contieneAgregadoDe(final Ingrediente i) {
    return this.agregados.containsKey(i);
  }
  
  public Agregado agregadoDe(final Ingrediente i) {
    return this.agregados.get(i);
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
  public Map<Ingrediente, Agregado> getAgregados() {
    return this.agregados;
  }
  
  public void setAgregados(final Map<Ingrediente, Agregado> agregados) {
    this.agregados = agregados;
  }
}
