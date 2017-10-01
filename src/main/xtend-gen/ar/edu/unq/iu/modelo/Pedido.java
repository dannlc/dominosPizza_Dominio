package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.CambioDeEstadoException;
import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.Cliente;
import ar.edu.unq.iu.modelo.ConstructorEmail;
import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.Preparando;
import com.google.common.base.Objects;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class Pedido extends Entity {
  private ConstructorEmail email = new ConstructorEmail();
  
  private List<Plato> platos = new ArrayList<Plato>();
  
  private Cliente cliente;
  
  private LocalDateTime fechaHora;
  
  private String aclaraciones = "";
  
  private Envio envio;
  
  private EstadoPedido estado;
  
  private int tiempoEspera;
  
  private Email mail;
  
  public Pedido(final Cliente cliente, final Envio envio) {
    this.cliente = cliente;
    this.fechaHora = LocalDateTime.now();
    this.envio = envio;
    Preparando _preparando = new Preparando();
    this.estado = _preparando;
    cliente.agregarPedido(this);
    this.tiempoEspera = 0;
  }
  
  @Dependencies("platos")
  public double getMonto() {
    double _xblockexpression = (double) 0;
    {
      double monto = this.envio.getCosto();
      for (final Plato p : this.platos) {
        double _monto = monto;
        double _precio = p.getPrecio();
        monto = (_monto + _precio);
      }
      _xblockexpression = monto;
    }
    return _xblockexpression;
  }
  
  public EstadoPedido cancelarPedido() {
    Cancelado _cancelado = new Cancelado();
    return this.estado = _cancelado;
  }
  
  public void enviar() {
    EnViaje _enViaje = new EnViaje();
    this.estado = _enViaje;
    this.mail = this.email.pedidoATiempo(this.cliente.getDireccion());
    new Mailer("aspmx.l.google.com", Integer.valueOf(25), "e-mail", "constrase�a").sendMail(this.mail);
  }
  
  public int entregar() {
    int _xblockexpression = (int) 0;
    {
      Entregado _entregado = new Entregado();
      this.estado = _entregado;
      this.verificarTiempo();
      _xblockexpression = this.calcularTiempoEspera();
    }
    return _xblockexpression;
  }
  
  public void verificarTiempo() {
    LocalDateTime _minusMinutes = LocalDateTime.now().minusMinutes(30);
    boolean _greaterEqualsThan = (_minusMinutes.compareTo(this.fechaHora) >= 0);
    if (_greaterEqualsThan) {
      this.mail = this.email.pedidoConDemora(this.cliente.getDireccion());
      new Mailer("aspmx.l.google.com", Integer.valueOf(25), "e-mail", "constrase�a").sendMail(this.mail);
    }
  }
  
  public List<EstadoPedido> getPosiblesEstados() {
    return this.estado.posiblesEstados(this);
  }
  
  public EstadoPedido pasarAlSiguienteEstado() {
    EstadoPedido _xblockexpression = null;
    {
      EstadoPedido _estadoSiguiente = this.estado.estadoSiguiente(this.envio);
      boolean _equals = Objects.equal(null, _estadoSiguiente);
      if (_equals) {
        throw new CambioDeEstadoException("imposible cambiar el estado del pedido");
      }
      _xblockexpression = this.estado = this.estado.estadoSiguiente(this.envio);
    }
    return _xblockexpression;
  }
  
  public EstadoPedido pasarAlEstadoAnterior() {
    EstadoPedido _xblockexpression = null;
    {
      EstadoPedido _estadoAnterior = this.estado.estadoAnterior(this.envio);
      boolean _equals = Objects.equal(null, _estadoAnterior);
      if (_equals) {
        throw new CambioDeEstadoException("imposible cambiar el estado del pedido");
      }
      _xblockexpression = this.estado = this.estado.estadoAnterior(this.envio);
    }
    return _xblockexpression;
  }
  
  public Boolean tieneEstadoAbierto() {
    return this.estado.esAbierto();
  }
  
  public int calcularTiempoEspera() {
    return this.tiempoEspera = Long.valueOf(ChronoUnit.MINUTES.between(LocalDateTime.now(), this.fechaHora)).intValue();
  }
  
  public boolean agregarPlato(final Plato plato) {
    boolean _xifexpression = false;
    boolean _contains = this.platos.contains(plato);
    boolean _not = (!_contains);
    if (_not) {
      _xifexpression = this.platos.add(plato);
    }
    return _xifexpression;
  }
  
  @Pure
  public ConstructorEmail getEmail() {
    return this.email;
  }
  
  public void setEmail(final ConstructorEmail email) {
    this.email = email;
  }
  
  @Pure
  public List<Plato> getPlatos() {
    return this.platos;
  }
  
  public void setPlatos(final List<Plato> platos) {
    this.platos = platos;
  }
  
  @Pure
  public Cliente getCliente() {
    return this.cliente;
  }
  
  public void setCliente(final Cliente cliente) {
    this.cliente = cliente;
  }
  
  @Pure
  public LocalDateTime getFechaHora() {
    return this.fechaHora;
  }
  
  public void setFechaHora(final LocalDateTime fechaHora) {
    this.fechaHora = fechaHora;
  }
  
  @Pure
  public String getAclaraciones() {
    return this.aclaraciones;
  }
  
  public void setAclaraciones(final String aclaraciones) {
    this.aclaraciones = aclaraciones;
  }
  
  @Pure
  public Envio getEnvio() {
    return this.envio;
  }
  
  public void setEnvio(final Envio envio) {
    this.envio = envio;
  }
  
  @Pure
  public EstadoPedido getEstado() {
    return this.estado;
  }
  
  public void setEstado(final EstadoPedido estado) {
    this.estado = estado;
  }
  
  @Pure
  public int getTiempoEspera() {
    return this.tiempoEspera;
  }
  
  public void setTiempoEspera(final int tiempoEspera) {
    this.tiempoEspera = tiempoEspera;
  }
  
  @Pure
  public Email getMail() {
    return this.mail;
  }
  
  public void setMail(final Email mail) {
    this.mail = mail;
  }
}
