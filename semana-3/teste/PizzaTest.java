import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 3/20/16.
 */
public class PizzaTest {
    @Before
    public void zerarIngredientes() {
        Pizza.zerarIngredientes();
    }

    @Test
    public void testGetPrecoCom2Ingredientes() {
        Pizza pizza = new Pizza();
        pizza.adicionaIngrediente("muzzarela");
        pizza.adicionaIngrediente("tomate");

        assertEquals(15, pizza.getPreco());
    }

    @Test
    public void testGetPrecoCom5Ingredientes() {
        Pizza pizza = new Pizza();
        pizza.adicionaIngrediente("muzzarela");
        pizza.adicionaIngrediente("tomate");
        pizza.adicionaIngrediente("oregano");
        pizza.adicionaIngrediente("ovo");
        pizza.adicionaIngrediente("presunto");

        assertEquals(20, pizza.getPreco());
    }

    @Test
    public void testGetPrecoCom6Ingredientes() {
        Pizza pizza = new Pizza();
        pizza.adicionaIngrediente("muzzarela");
        pizza.adicionaIngrediente("tomate");
        pizza.adicionaIngrediente("presunto");
        pizza.adicionaIngrediente("ovo");
        pizza.adicionaIngrediente("oregano");
        pizza.adicionaIngrediente("manjericão");

        assertEquals(22, pizza.getPreco());
    }


    @Test
    public void testIngredientes() {
        Pizza pizza = new Pizza();
        pizza.adicionaIngrediente("muzzarela");

        assertEquals(1, Pizza.ingredientesTotais.getOrDefault("muzzarela", 0).intValue());
    }
}