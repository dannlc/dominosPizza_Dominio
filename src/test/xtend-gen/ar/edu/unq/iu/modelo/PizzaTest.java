package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pizza;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PizzaTest {
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
  }
  
  @Test
  public void UnaPizzaDeJamonYMorronesSale80PeTest() {
    Pizza _pizza = new Pizza("Jamon y Morrones", 80.0);
    final Procedure1<Pizza> _function = (Pizza it) -> {
      it.getIngredientes().add(this.jamon);
      it.getIngredientes().add(this.morron);
    };
    Pizza _doubleArrow = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza, _function);
    this.jym = _doubleArrow;
    Assert.assertEquals(this.jym.getPrecio(), 80.0, 0.0);
  }
  
  @Test
  public void UnaPizzaDeMuzzaSale70PeTest() {
    Pizza _pizza = new Pizza("Muzzarella", 70.0);
    final Procedure1<Pizza> _function = (Pizza it) -> {
      it.getIngredientes().add(this.queso);
    };
    Pizza _doubleArrow = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza, _function);
    this.muzza = _doubleArrow;
    Assert.assertEquals(this.muzza.getPrecio(), 70.0, 0.0);
  }
  
  @Test
  public void LaGrandeDeMuzzaAumentoTest() {
    Pizza _pizza = new Pizza("Muzzarella", 70.0);
    final Procedure1<Pizza> _function = (Pizza it) -> {
      it.getIngredientes().add(this.queso);
    };
    Pizza _doubleArrow = ObjectExtensions.<Pizza>operator_doubleArrow(_pizza, _function);
    this.muzza = _doubleArrow;
    this.muzza.setPrecio(120);
    Assert.assertEquals(this.muzza.getPrecio(), 120.0, 0.0);
  }
}
