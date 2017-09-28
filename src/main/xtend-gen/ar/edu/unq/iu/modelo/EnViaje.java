package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.ListoParaEnviar;

@SuppressWarnings("all")
public class EnViaje extends EstadoPedido {
  public EnViaje() {
  }
  
  @Override
  public String nombre() {
    return "En Viaje";
  }
  
  @Override
  public EstadoPedido estadoSiguiente(final Envio e) {
    return new Entregado();
  }
  
  @Override
  public EstadoPedido estadoAnterior(final Envio e) {
    return new ListoParaEnviar();
  }
  
  @Override
  public Boolean esAbierto() {
    return Boolean.valueOf(true);
  }
  
  @Override
  public String toString() {
    return this.nombre();
  }
}
