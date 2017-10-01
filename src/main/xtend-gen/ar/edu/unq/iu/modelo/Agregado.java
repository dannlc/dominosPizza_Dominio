package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Lado;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class Agregado {
  private Ingrediente ingrediente;
  
  private Lado lado;
  
  public Agregado(final Ingrediente ingrediente, final Lado cubre) {
    this.ingrediente = ingrediente;
    this.lado = this.lado;
  }
  
  public Double getPrecio() {
    return this.ingrediente.getPrecio();
  }
  
  @Pure
  public Ingrediente getIngrediente() {
    return this.ingrediente;
  }
  
  public void setIngrediente(final Ingrediente ingrediente) {
    this.ingrediente = ingrediente;
  }
  
  @Pure
  public Lado getLado() {
    return this.lado;
  }
  
  public void setLado(final Lado lado) {
    this.lado = lado;
  }
}
