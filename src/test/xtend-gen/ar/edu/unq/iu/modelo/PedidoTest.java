package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.CambioDeEstadoException;
import ar.edu.unq.iu.modelo.Cancelado;
import ar.edu.unq.iu.modelo.Cliente;
import ar.edu.unq.iu.modelo.Delivery;
import ar.edu.unq.iu.modelo.EnViaje;
import ar.edu.unq.iu.modelo.Entregado;
import ar.edu.unq.iu.modelo.Envio;
import ar.edu.unq.iu.modelo.EstadoPedido;
import ar.edu.unq.iu.modelo.ListoParaEnviar;
import ar.edu.unq.iu.modelo.ListoParaRetirar;
import ar.edu.unq.iu.modelo.Pedido;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.Preparando;
import ar.edu.unq.iu.modelo.Retirar;
import ar.edu.unq.iu.modelo.TamanioGrande;
import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PedidoTest {
  private Pedido pedidoSinPlatos;
  
  private Pedido pedidoConPlatos;
  
  private Cliente cliente;
  
  private String aclaraciones;
  
  private Envio delivery;
  
  private Envio retiro;
  
  @Before
  public void setUp() {
    Cliente _cliente = new Cliente("nombre", "nick", "password", "mail", "direccion");
    this.cliente = _cliente;
    Delivery _delivery = new Delivery("Calle Falsa 123");
    this.delivery = _delivery;
    Retirar _retirar = new Retirar();
    this.retiro = _retirar;
    Pedido _pedido = new Pedido(this.cliente, this.delivery);
    this.pedidoSinPlatos = _pedido;
    Pedido _pedido_1 = new Pedido(this.cliente, this.retiro);
    final Procedure1<Pedido> _function = (Pedido it) -> {
      Pizza _pizza = new Pizza("muzza", 70.0);
      TamanioGrande _tamanioGrande = new TamanioGrande();
      Plato _plato = new Plato(_pizza, _tamanioGrande);
      it.getPlatos().add(_plato);
    };
    Pedido _doubleArrow = ObjectExtensions.<Pedido>operator_doubleArrow(_pedido_1, _function);
    this.pedidoConPlatos = _doubleArrow;
  }
  
  @Test
  public void testDadoUnPedidoSuEstadoEsEnPreparacion() {
    Class<? extends EstadoPedido> _class = this.pedidoSinPlatos.getEstado().getClass();
    boolean _equals = Objects.equal(_class, Preparando.class);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testDadoUnPedidoCalculoSuPrecio() {
    double _monto = this.pedidoSinPlatos.getMonto();
    boolean _equals = (_monto == 15.0);
    Assert.assertTrue(_equals);
    double _monto_1 = this.pedidoConPlatos.getMonto();
    boolean _equals_1 = (_monto_1 == 70.0);
    Assert.assertTrue(_equals_1);
  }
  
  @Test
  public void testDadoUnPedidoEsteEsCancelado() {
    this.pedidoSinPlatos.cancelarPedido();
    Class<? extends EstadoPedido> _class = this.pedidoSinPlatos.getEstado().getClass();
    boolean _equals = Objects.equal(_class, Cancelado.class);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testDadoUnPedidoQueTardoMasDe30MinutosEnserEntregadoSeVerificaQueElClienteRecibaElMailCorrespondiente() {
  }
  
  @Test(expected = CambioDeEstadoException.class)
  public void testUnPedidoEnEstadoPreparandoRompeSiLoQueremosPasarAlAnterior() {
    this.pedidoConPlatos.pasarAlEstadoAnterior();
  }
  
  @Test(expected = CambioDeEstadoException.class)
  public void testUnPedidoEnEstadoCanceladoRompeSiLoQueremosPasarAlAnterior() {
    Cancelado _cancelado = new Cancelado();
    this.pedidoConPlatos.setEstado(_cancelado);
    this.pedidoConPlatos.pasarAlEstadoAnterior();
  }
  
  @Test(expected = CambioDeEstadoException.class)
  public void testUnPedidoEnEstadoEntregadoRompeSiLoQueremosPasarAlSiguiente() {
    Entregado _entregado = new Entregado();
    this.pedidoConPlatos.setEstado(_entregado);
    this.pedidoConPlatos.pasarAlSiguienteEstado();
  }
  
  @Test(expected = CambioDeEstadoException.class)
  public void testUnPedidoEnEstadoCanceladoRompeSiLoQueremosPasarAlSiguiente() {
    Cancelado _cancelado = new Cancelado();
    this.pedidoConPlatos.setEstado(_cancelado);
    this.pedidoConPlatos.pasarAlSiguienteEstado();
  }
  
  @Test
  public void testUnPedidoParaEnviarPasaAEstadosSiguientes() {
    this.pedidoSinPlatos.pasarAlSiguienteEstado();
    ListoParaEnviar _listoParaEnviar = new ListoParaEnviar();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _listoParaEnviar);
    this.pedidoSinPlatos.pasarAlSiguienteEstado();
    EnViaje _enViaje = new EnViaje();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _enViaje);
    this.pedidoSinPlatos.pasarAlSiguienteEstado();
    Entregado _entregado = new Entregado();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _entregado);
  }
  
  @Test
  public void testUnPedidoParaEnviarPasaAEstadosAnteriores() {
    Entregado _entregado = new Entregado();
    this.pedidoSinPlatos.setEstado(_entregado);
    this.pedidoSinPlatos.pasarAlEstadoAnterior();
    EnViaje _enViaje = new EnViaje();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _enViaje);
    this.pedidoSinPlatos.pasarAlEstadoAnterior();
    ListoParaEnviar _listoParaEnviar = new ListoParaEnviar();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _listoParaEnviar);
    this.pedidoSinPlatos.pasarAlEstadoAnterior();
    Preparando _preparando = new Preparando();
    Assert.assertEquals(this.pedidoSinPlatos.getEstado(), _preparando);
  }
  
  @Test
  public void testUnPedidoParaRetirarPasaALosEstadosSiguientes() {
    this.pedidoConPlatos.pasarAlSiguienteEstado();
    ListoParaRetirar _listoParaRetirar = new ListoParaRetirar();
    Assert.assertEquals(this.pedidoConPlatos.getEstado(), _listoParaRetirar);
    this.pedidoConPlatos.pasarAlSiguienteEstado();
    Entregado _entregado = new Entregado();
    Assert.assertEquals(this.pedidoConPlatos.getEstado(), _entregado);
  }
  
  @Test
  public void testUnPedidoParaRetirarPasaALosEstadosAnteriores() {
    Entregado _entregado = new Entregado();
    this.pedidoConPlatos.setEstado(_entregado);
    this.pedidoConPlatos.pasarAlEstadoAnterior();
    ListoParaRetirar _listoParaRetirar = new ListoParaRetirar();
    Assert.assertEquals(this.pedidoConPlatos.getEstado(), _listoParaRetirar);
    this.pedidoConPlatos.pasarAlEstadoAnterior();
    Preparando _preparando = new Preparando();
    Assert.assertEquals(this.pedidoConPlatos.getEstado(), _preparando);
  }
}
