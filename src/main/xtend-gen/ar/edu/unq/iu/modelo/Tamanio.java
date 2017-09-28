package ar.edu.unq.iu.modelo;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;

@Accessors
@SuppressWarnings("all")
public abstract class Tamanio extends Entity {
  private double precio;
  
  private String nombre;
  
  @Override
  public String toString() {
    return this.nombre;
  }
  
  @Override
  public boolean equals(final Object o) {
    Class<? extends Tamanio> _class = this.getClass();
    Class<?> _class_1 = o.getClass();
    return Objects.equal(_class, _class_1);
  }
  
  @Pure
  public double getPrecio() {
    return this.precio;
  }
  
  public void setPrecio(final double precio) {
    this.precio = precio;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
}
