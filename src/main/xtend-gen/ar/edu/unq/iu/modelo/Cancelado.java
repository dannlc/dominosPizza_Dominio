package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.EstadoPedido;

@SuppressWarnings("all")
public class Cancelado extends EstadoPedido {
  public Cancelado() {
  }
  
  @Override
  public String nombre() {
    return "Cancelado";
  }
  
  @Override
  public Boolean esAbierto() {
    return Boolean.valueOf(false);
  }
  
  @Override
  public String toString() {
    return this.nombre();
  }
}
