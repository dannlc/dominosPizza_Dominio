package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Agregado;
import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.LadoAmbos;
import ar.edu.unq.iu.modelo.LadoIzquierdo;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.modelo.Plato;
import ar.edu.unq.iu.modelo.TamanioFamiliar;
import ar.edu.unq.iu.modelo.TamanioPorcion;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PlatoTest {
  private Ingrediente jamon;
  
  private Ingrediente queso;
  
  private Ingrediente aceitunas;
  
  private Ingrediente morron;
  
  private Pizza muzza;
  
  private Pizza jym;
  
  @Before
  public void setUp() {
    Ingrediente _ingrediente = new Ingrediente("jamon", Double.valueOf(10.0));
    this.jamon = _ingrediente;
    Ingrediente _ingrediente_1 = new Ingrediente("queso", Double.valueOf(14.0));
    this.queso = _ingrediente_1;
    Ingrediente _ingrediente_2 = new Ingrediente("aceitunas", Double.valueOf(8.0));
    this.aceitunas = _ingrediente_2;
    Ingrediente _ingrediente_3 = new Ingrediente("morron", Double.valueOf(20.0));
    this.morron = _ingrediente_3;
    Pizza _pizza = new Pizza("Muzzarella", 70.0);
    final Procedure1<Pizza> _function = (Pizza it) -> {
      it.getIngredientes().add(this.queso);
    };
    Pizza _doubleArrow = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza, _function);
    this.muzza = _doubleArrow;
    Pizza _pizza_1 = new Pizza("Jamon y Morrones", 80.0);
    final Procedure1<Pizza> _function_1 = (Pizza it) -> {
      it.getIngredientes().add(this.jamon);
      it.getIngredientes().add(this.morron);
    };
    Pizza _doubleArrow_1 = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza_1, _function_1);
    this.jym = _doubleArrow_1;
  }
  
  @Test
  public void UnaFamiliarDeMuzzaConMorronesTieneElPrecioCorrectoTest() {
    TamanioFamiliar _tamanioFamiliar = new TamanioFamiliar();
    Plato _plato = new Plato(this.muzza, _tamanioFamiliar);
    final Procedure1<Plato> _function = (Plato it) -> {
      LadoAmbos _ladoAmbos = new LadoAmbos();
      Agregado _agregado = new Agregado(this.morron, _ladoAmbos);
      it.agregarAgregado(_agregado);
    };
    final Plato plato = ObjectExtensions.<Plato>operator_doubleArrow(_plato, _function);
    Assert.assertEquals(plato.getPrecio(), ((70.0 * 1.25) + 20.0), 0.0);
  }
  
  @Test
  public void UnaPorcionDeJamonYMorronesConAceitunasTieneElPrecioCorrectoTest() {
    TamanioPorcion _tamanioPorcion = new TamanioPorcion();
    Plato _plato = new Plato(this.jym, _tamanioPorcion);
    final Procedure1<Plato> _function = (Plato it) -> {
      LadoIzquierdo _ladoIzquierdo = new LadoIzquierdo();
      Agregado _agregado = new Agregado(this.aceitunas, _ladoIzquierdo);
      it.agregarAgregado(_agregado);
    };
    final Plato plato = ObjectExtensions.<Plato>operator_doubleArrow(_plato, _function);
    Assert.assertEquals(plato.getPrecio(), ((80.0 * 0.25) + 8.0), 0.0);
  }
}
