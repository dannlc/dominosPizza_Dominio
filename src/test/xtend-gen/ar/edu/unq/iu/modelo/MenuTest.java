package ar.edu.unq.iu.modelo;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Menu;
import ar.edu.unq.iu.modelo.Pizza;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class MenuTest {
  private Menu menu;
  
  private Pizza pizza1;
  
  private Pizza pizza2;
  
  private Ingrediente panceta;
  
  private Ingrediente aceitunas;
  
  @Before
  public void setUp() {
    Menu _menu = new Menu();
    this.menu = _menu;
    Pizza _pizza = new Pizza("Jamon y Morrones", 0.0);
    this.pizza1 = _pizza;
    Pizza _pizza_1 = new Pizza("Panceta", 0.0);
    this.pizza2 = _pizza_1;
    Ingrediente _ingrediente = new Ingrediente("Panceta", Double.valueOf(5.0));
    this.panceta = _ingrediente;
    Ingrediente _ingrediente_1 = new Ingrediente("Aceitunas", Double.valueOf(3.5));
    this.aceitunas = _ingrediente_1;
  }
  
  @Test
  public void testAgregaUnaPizzaAlMenu() {
    this.menu.agregarPizza(this.pizza1);
    Assert.assertEquals(this.menu.cantidadDePizzas(), 1);
    Assert.assertTrue(this.menu.tienePizza(this.pizza1));
  }
  
  @Test
  public void testQuitarUnaPizzaAlMenu() {
    this.menu.agregarPizza(this.pizza1);
    this.menu.agregarPizza(this.pizza2);
    this.menu.quitarPizza(this.pizza1);
    Assert.assertEquals(this.menu.cantidadDePizzas(), 1);
    Assert.assertFalse(this.menu.tienePizza(this.pizza1));
  }
  
  @Test
  public void testEditarUnaPizza() {
    this.menu.agregarPizza(this.pizza2);
    this.menu.quitarIngredientePizza(this.pizza2, this.panceta);
    this.menu.agregarIngredientePizza(this.pizza2, this.aceitunas);
    this.menu.cambiarNombrePizza(this.pizza2, "PizzaAceituna");
    this.menu.cambiarPrecioPizza(this.pizza2, 150.0);
    Assert.assertEquals(this.pizza2.getNombre(), "PizzaAceituna");
    Assert.assertTrue(this.pizza2.getIngredientes().contains(this.aceitunas));
    Assert.assertFalse(this.pizza2.getIngredientes().contains(this.panceta));
    Assert.assertEquals(this.pizza2.getIngredientes().size(), 1);
    double _precio = this.pizza2.getPrecio();
    boolean _equals = (_precio == 150.0);
    Assert.assertTrue(_equals);
  }
  
  @Test
  public void testAgregarIngredienteExtraAlMenu() {
    this.menu.agregarIngredienteExtra(this.panceta);
    Assert.assertEquals(this.menu.cantidadDeIngredientesExtras(), 1);
    Assert.assertTrue(this.menu.tieneIngredienteExtra(this.panceta));
  }
  
  @Test
  public void testQuitarIngredienteExtraAlMenu() {
    this.menu.agregarIngredienteExtra(this.panceta);
    this.menu.agregarIngredienteExtra(this.aceitunas);
    this.menu.quitarIngredienteExtra(this.panceta);
    Assert.assertEquals(this.menu.cantidadDeIngredientesExtras(), 1);
    Assert.assertFalse(this.menu.tieneIngredienteExtra(this.panceta));
  }
  
  @Test
  public void testEditarIngrediente() {
    this.menu.agregarIngredienteExtra(this.panceta);
    this.menu.cambiarNombreIngrediente(this.panceta, "Bacon");
    this.menu.cambiarPrecioIngrediente(this.panceta, 10.0);
    Assert.assertEquals(this.panceta.getNombre(), "Bacon");
    Assert.assertEquals(this.menu.getIngreExtras().size(), 1);
    Double _precio = this.panceta.getPrecio();
    boolean _equals = ((_precio).doubleValue() == 10.0);
    Assert.assertTrue(_equals);
  }
}
