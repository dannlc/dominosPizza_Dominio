package ar.edu.unq.iu.repo;

import ar.edu.unq.iu.modelo.Cliente;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedRepo;

@SuppressWarnings("all")
public class RepoCliente extends CollectionBasedRepo<Cliente> {
  public Cliente create(final String nombre, final String nick, final String password, final String mail, final String direccion) {
    final Cliente c = new Cliente(nombre, nick, password, mail, direccion);
    this.create(c);
    return c;
  }
  
  @Override
  protected Predicate<Cliente> getCriterio(final Cliente example) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Cliente createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Class<Cliente> getEntityType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
