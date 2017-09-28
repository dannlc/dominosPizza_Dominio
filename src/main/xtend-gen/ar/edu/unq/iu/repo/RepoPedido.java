package ar.edu.unq.iu.repo;

import ar.edu.unq.iu.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.CollectionBasedRepo;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@SuppressWarnings("all")
public class RepoPedido extends CollectionBasedRepo<Pedido> {
  @Override
  protected Predicate<Pedido> getCriterio(final Pedido arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Pedido createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Class<Pedido> getEntityType() {
    return Pedido.class;
  }
  
  public ArrayList<Pedido> getPedidosAbiertos() {
    ArrayList<Pedido> _xblockexpression = null;
    {
      ArrayList<Pedido> p = CollectionLiterals.<Pedido>newArrayList();
      List<Pedido> _objects = this.getObjects();
      for (final Pedido o : _objects) {
        Boolean _tieneEstadoAbierto = o.tieneEstadoAbierto();
        if ((_tieneEstadoAbierto).booleanValue()) {
          p.add(o);
        }
      }
      _xblockexpression = p;
    }
    return _xblockexpression;
  }
  
  public ArrayList<Pedido> getPedidosCerrados() {
    ArrayList<Pedido> _xblockexpression = null;
    {
      ArrayList<Pedido> p = CollectionLiterals.<Pedido>newArrayList();
      List<Pedido> _objects = this.getObjects();
      for (final Pedido o : _objects) {
        Boolean _tieneEstadoAbierto = o.tieneEstadoAbierto();
        boolean _not = (!(_tieneEstadoAbierto).booleanValue());
        if (_not) {
          p.add(o);
        }
      }
      _xblockexpression = p;
    }
    return _xblockexpression;
  }
}
