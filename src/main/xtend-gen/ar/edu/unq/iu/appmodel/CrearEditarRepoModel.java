package ar.edu.unq.iu.appmodel;

import java.io.Serializable;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.utils.ObservableUtils;

/**
 * creador y editor generico para un repo
 */
@Observable
@Accessors
@SuppressWarnings("all")
public class CrearEditarRepoModel<T extends Entity> implements Serializable {
  private CollectionBasedRepo<T> repo;
  
  private T seleccionado;
  
  public CrearEditarRepoModel(final CollectionBasedRepo<T> repo) {
    this.repo = repo;
  }
  
  public List<T> objetos() {
    return this.repo.getObjects();
  }
  
  public void actualizar() {
    ObservableUtils.firePropertyChanged(this, "objetos");
  }
  
  @Pure
  public CollectionBasedRepo<T> getRepo() {
    return this.repo;
  }
  
  public void setRepo(final CollectionBasedRepo<T> repo) {
    this.repo = repo;
  }
  
  @Pure
  public T getSeleccionado() {
    return this.seleccionado;
  }
  
  public void setSeleccionado(final T seleccionado) {
    this.seleccionado = seleccionado;
  }
}
