package ar.edu.unq.iu.modelo;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;

@Accessors
@SuppressWarnings("all")
public class ConstructorEmail {
  private Email email;
  
  private final String DEMORAS = "El pedido llegara con demoras, sepa disculpar las molestias.";
  
  private final String A_TIEMPO = "Su pedido esta en viaje.";
  
  public Email pedidoConDemora(final String to) {
    this.email = new EmailBuilder().from("Pizza Hutt", "danncorbalan@gmail.com").to("cliente", to).subject(this.DEMORAS).text(this.DEMORAS).build();
    return this.email;
  }
  
  public Email pedidoATiempo(final String to) {
    this.email = new EmailBuilder().from("Pizza Hutt", "danncorbalan@gmail.com").to("cliente", to).subject(this.A_TIEMPO).text(this.A_TIEMPO).build();
    return this.email;
  }
  
  @Pure
  public Email getEmail() {
    return this.email;
  }
  
  public void setEmail(final Email email) {
    this.email = email;
  }
  
  @Pure
  public String getDEMORAS() {
    return this.DEMORAS;
  }
  
  @Pure
  public String getA_TIEMPO() {
    return this.A_TIEMPO;
  }
}
