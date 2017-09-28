package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.ListoParaEnviar;
import ar.edu.unq.iu.modelo.Preparando;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Delivery extends Envio {
  private String direccion;
  
  public Delivery(final String direc) {
    super();
    this.costo = 15.0;
    this.direccion = direc;
  }
  
  @Override
  public List<Object> getPosiblesEstados() {
    Preparando _preparando = new Preparando();
    ListoParaEnviar _listoParaEnviar = new ListoParaEnviar();
    EnViaje _enViaje = new EnViaje();
    Entregado _entregado = new Entregado();
    Cancelado _cancelado = new Cancelado();
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_preparando, _listoParaEnviar, _enViaje, _entregado, _cancelado));
  }
  
  @Pure
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(final String direccion) {
    this.direccion = direccion;
  }
}
