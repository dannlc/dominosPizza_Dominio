package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class Pizza extends Entity {
  private String nombre;
  
  private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
  
  private double precio;
  
  public Pizza(final String n, final double p) {
    this.nombre = n;
    this.precio = p;
  }
  
  @Dependencies("ingredientes")
  public boolean quitarIngrediente(final Ingrediente ingrediente) {
    return this.ingredientes.remove(ingrediente);
  }
  
  @Dependencies("ingredientes")
  public boolean agregarIngrediente(final Ingrediente ingrediente) {
    return this.ingredientes.add(ingrediente);
  }
  
  public double getPrecio() {
    return this.precio;
  }
  
  public boolean tieneIngrediente(final Ingrediente i) {
    return this.ingredientes.contains(i);
  }
  
  @Override
  public String toString() {
    return this.nombre;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public List<Ingrediente> getIngredientes() {
    return this.ingredientes;
  }
  
  public void setIngredientes(final List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }
  
  public void setPrecio(final double precio) {
    this.precio = precio;
  }
}
