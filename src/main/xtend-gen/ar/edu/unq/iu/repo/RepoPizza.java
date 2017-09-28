package ar.edu.unq.iu.repo;

import ar.edu.unq.iu.modelo.Pizza;
import com.google.common.base.Objects;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@SuppressWarnings("all")
public class RepoPizza extends CollectionBasedRepo<Pizza> {
  @Override
  protected Predicate<Pizza> getCriterio(final Pizza example) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Pizza createExample() {
    return new Pizza("Muzzarela", 75.0);
  }
  
  @Override
  public Class<Pizza> getEntityType() {
    return Pizza.class;
  }
  
  public List<Pizza> getPizza(final Pizza p) {
    final Function1<Pizza, Boolean> _function = (Pizza pizza) -> {
      return Boolean.valueOf(this.match(p, pizza.getNombre()));
    };
    return IterableExtensions.<Pizza>toList(IterableExtensions.<Pizza>filter(this.allInstances(), _function));
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      _xblockexpression = realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
    }
    return _xblockexpression;
  }
}
