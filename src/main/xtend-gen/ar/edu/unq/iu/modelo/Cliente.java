package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Pedido;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class Cliente extends Entity {
  private String nombre;
  
  private String nick;
  
  private String password;
  
  private String mail;
  
  private String direccion;
  
  private List<Pedido> pedidos;
  
  public Cliente(final String nombre, final String nick, final String password, final String mail, final String direccion) {
    this.nombre = nombre;
    this.nick = nick;
    this.password = password;
    this.mail = mail;
    this.direccion = direccion;
    this.pedidos = CollectionLiterals.<Pedido>newArrayList();
  }
  
  public boolean agregarPedido(final Pedido pedido) {
    return this.pedidos.add(pedido);
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getNick() {
    return this.nick;
  }
  
  public void setNick(final String nick) {
    this.nick = nick;
  }
  
  @Pure
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(final String password) {
    this.password = password;
  }
  
  @Pure
  public String getMail() {
    return this.mail;
  }
  
  public void setMail(final String mail) {
    this.mail = mail;
  }
  
  @Pure
  public String getDireccion() {
    return this.direccion;
  }
  
  public void setDireccion(final String direccion) {
    this.direccion = direccion;
  }
  
  @Pure
  public List<Pedido> getPedidos() {
    return this.pedidos;
  }
  
  public void setPedidos(final List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
}
