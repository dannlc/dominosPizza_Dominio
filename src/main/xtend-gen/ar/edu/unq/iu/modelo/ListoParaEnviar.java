package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.Preparando;

@SuppressWarnings("all")
public class ListoParaEnviar extends EstadoPedido {
  public ListoParaEnviar() {
  }
  
  @Override
  public EstadoPedido estadoSiguiente(final Envio e) {
    return new EnViaje();
  }
  
  @Override
  public EstadoPedido estadoAnterior(final Envio e) {
    return new Preparando();
  }
  
  @Override
  public Boolean esAbierto() {
    return Boolean.valueOf(true);
  }
  
  @Override
  public String toString() {
    return this.nombre();
  }
  
  @Override
  public String nombre() {
    return "Listo Para Enviar";
  }
}
