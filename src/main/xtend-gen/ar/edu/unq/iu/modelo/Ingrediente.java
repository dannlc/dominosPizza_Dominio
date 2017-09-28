package ar.edu.unq.iu.modelo;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class Ingrediente extends Entity {
  private String nombre;
  
  private Double precio;
  
  public Ingrediente(final String n, final Double p) {
    this.nombre = n;
    this.precio = p;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public Double getPrecio() {
    return this.precio;
  }
  
  public void setPrecio(final Double precio) {
    this.precio = precio;
  }
}
