package ar.edu.unq.iu.appmodel;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.Tamanio;
import ar.edu.unq.iu.modelo.TamanioChica;
import ar.edu.unq.iu.modelo.TamanioFamiliar;
import ar.edu.unq.iu.modelo.TamanioGrande;
import ar.edu.unq.iu.modelo.TamanioPorcion;
import ar.edu.unq.iu.repo.RepoIngrediente;
import ar.edu.unq.iu.repo.RepoPizza;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@TransactionalAndObservable
@Accessors
@SuppressWarnings("all")
public class PlatoAppModel implements Serializable {
  private Plato plato;
  
  private Pedido pedido;
  
  public PlatoAppModel(final Pedido pedido, final Plato plato) {
    this.plato = plato;
    this.pedido = pedido;
  }
  
  public RepoPizza getRepoPizza() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pizza.class);
    return ((RepoPizza) _singleton);
  }
  
  public RepoIngrediente getRepoIngrediente() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Ingrediente.class);
    return ((RepoIngrediente) _singleton);
  }
  
  public List<? extends Tamanio> getTamanios() {
    TamanioPorcion _tamanioPorcion = new TamanioPorcion();
    TamanioChica _tamanioChica = new TamanioChica();
    TamanioGrande _tamanioGrande = new TamanioGrande();
    TamanioFamiliar _tamanioFamiliar = new TamanioFamiliar();
    return Collections.<Tamanio>unmodifiableList(CollectionLiterals.<Tamanio>newArrayList(_tamanioPorcion, _tamanioChica, _tamanioGrande, _tamanioFamiliar));
  }
  
  public Iterable<Ingrediente> ingredientesPosibles() {
    final Function1<Ingrediente, Boolean> _function = (Ingrediente it) -> {
      boolean _contains = this.plato.getPizza().getIngredientes().contains(it);
      return Boolean.valueOf((!_contains));
    };
    return IterableExtensions.<Ingrediente>filter(this.getRepoIngrediente().getObjects(), _function);
  }
  
  public boolean agregarPlato() {
    return this.pedido.agregarPlato(this.plato);
  }
  
  @Pure
  public Plato getPlato() {
    return this.plato;
  }
  
  public void setPlato(final Plato plato) {
    this.plato = plato;
  }
  
  @Pure
  public Pedido getPedido() {
    return this.pedido;
  }
  
  public void setPedido(final Pedido pedido) {
    this.pedido = pedido;
  }
}
