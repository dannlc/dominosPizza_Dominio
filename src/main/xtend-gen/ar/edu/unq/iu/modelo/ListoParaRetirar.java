package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.Preparando;

@SuppressWarnings("all")
public class ListoParaRetirar extends EstadoPedido {
  public ListoParaRetirar() {
  }
  
  @Override
  public String nombre() {
    return "Listo Para Retirar";
  }
  
  @Override
  public EstadoPedido estadoSiguiente(final Envio e) {
    return new Entregado();
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
}
