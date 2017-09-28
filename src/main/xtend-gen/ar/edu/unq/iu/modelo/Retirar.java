package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.ListoParaRetirar;
import ar.edu.unq.iu.modelo.Preparando;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class Retirar extends Envio {
  public Retirar() {
    super();
    this.costo = 0.0;
  }
  
  @Override
  public List<Object> getPosiblesEstados() {
    Preparando _preparando = new Preparando();
    ListoParaRetirar _listoParaRetirar = new ListoParaRetirar();
    Entregado _entregado = new Entregado();
    Cancelado _cancelado = new Cancelado();
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_preparando, _listoParaRetirar, _entregado, _cancelado));
  }
}
