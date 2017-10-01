package ar.edu.unq.iu.modelo;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.uqbar.commons.model.annotations.TransactionalAndObservable;

@Accessors
@TransactionalAndObservable
@SuppressWarnings("all")
public class Lado {
  @Override
  public boolean equals(final Object o) {
    Class<? extends Lado> _class = this.getClass();
    Class<?> _class_1 = o.getClass();
    return Objects.equal(_class, _class_1);
  }
}
