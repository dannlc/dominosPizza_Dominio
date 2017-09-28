package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pizza;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Menu {
  private List<Pizza> pizzas;
  
  private List<Ingrediente> ingreExtras;
  
  public Menu() {
    this.pizzas = CollectionLiterals.<Pizza>newArrayList();
    this.ingreExtras = CollectionLiterals.<Ingrediente>newArrayList();
  }
  
  public boolean agregarPizza(final Pizza p) {
    return this.pizzas.add(p);
  }
  
  public boolean quitarPizza(final Pizza p) {
    return this.pizzas.remove(p);
  }
  
  public int cantidadDePizzas() {
    return this.pizzas.size();
  }
  
  public boolean agregarIngredienteExtra(final Ingrediente i) {
    return this.ingreExtras.add(i);
  }
  
  public boolean quitarIngredienteExtra(final Ingrediente i) {
    return this.ingreExtras.remove(i);
  }
  
  public boolean tienePizza(final Pizza p) {
    return this.pizzas.contains(p);
  }
  
  public int cantidadDeIngredientesExtras() {
    return this.ingreExtras.size();
  }
  
  public boolean tieneIngredienteExtra(final Ingrediente i) {
    return this.ingreExtras.contains(i);
  }
  
  public void quitarIngredientePizza(final Pizza pizza, final Ingrediente ingrediente) {
    for (final Pizza p : this.pizzas) {
      boolean _equals = Objects.equal(p, pizza);
      if (_equals) {
        p.quitarIngrediente(ingrediente);
      }
    }
  }
  
  public void agregarIngredientePizza(final Pizza pizza, final Ingrediente ingrediente) {
    for (final Pizza p : this.pizzas) {
      boolean _equals = Objects.equal(p, pizza);
      if (_equals) {
        p.agregarIngrediente(ingrediente);
      }
    }
  }
  
  public void cambiarNombrePizza(final Pizza pizza, final String string) {
    for (final Pizza p : this.pizzas) {
      boolean _equals = Objects.equal(p, pizza);
      if (_equals) {
        p.setNombre(string);
      }
    }
  }
  
  public void cambiarPrecioPizza(final Pizza pizza, final double d) {
    for (final Pizza p : this.pizzas) {
      boolean _equals = Objects.equal(p, pizza);
      if (_equals) {
        p.setPrecio(d);
      }
    }
  }
  
  public void cambiarNombreIngrediente(final Ingrediente ingrediente, final String string) {
    for (final Ingrediente i : this.ingreExtras) {
      boolean _equals = Objects.equal(i, ingrediente);
      if (_equals) {
        i.setNombre(string);
      }
    }
  }
  
  public void cambiarPrecioIngrediente(final Ingrediente ingrediente, final double d) {
    for (final Ingrediente i : this.ingreExtras) {
      boolean _equals = Objects.equal(i, ingrediente);
      if (_equals) {
        i.setPrecio(Double.valueOf(d));
      }
    }
  }
  
  @Pure
  public List<Pizza> getPizzas() {
    return this.pizzas;
  }
  
  public void setPizzas(final List<Pizza> pizzas) {
    this.pizzas = pizzas;
  }
  
  @Pure
  public List<Ingrediente> getIngreExtras() {
    return this.ingreExtras;
  }
  
  public void setIngreExtras(final List<Ingrediente> ingreExtras) {
    this.ingreExtras = ingreExtras;
  }
}
