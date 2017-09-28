package ar.edu.unq.iu.modelo;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public abstract class Envio {
  protected double costo;
  
  @Override
  public boolean equals(final Object o) {
    Class<? extends Envio> _class = this.getClass();
    Class<?> _class_1 = o.getClass();
    return Objects.equal(_class, _class_1);
  }
  
  public List<Object> getPosiblesEstados() {
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
  }
  
  @Pure
  public double getCosto() {
    return this.costo;
  }
  
  public void setCosto(final double costo) {
    this.costo = costo;
  }
}
