package ar.edu.unq.iu.repo;

import ar.edu.unq.iu.modelo.Ingrediente;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedRepo;

@SuppressWarnings("all")
public class RepoIngrediente extends CollectionBasedRepo<Ingrediente> {
  public Ingrediente create(final String pNombre, final double valor) {
    final Ingrediente i = new Ingrediente(pNombre, Double.valueOf(valor));
    this.create(i);
    return i;
  }
  
  @Override
  protected Predicate<Ingrediente> getCriterio(final Ingrediente arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Ingrediente createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Class<Ingrediente> getEntityType() {
    return Ingrediente.class;
  }
  
  public List<Ingrediente> getAllIngredientes() {
    return this.allInstances();
  }
}
