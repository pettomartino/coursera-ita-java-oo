import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 3/20/16.
 */
public class CarrinhoDeComprasTest {

    @Test
    public void testAdicionarPizza() {
        Pizza pizza_sem_ingredientes = new Pizza();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarPizza(pizza_sem_ingredientes);

        assertEquals(0, carrinho.totalDePizzas());
    }

    @Test
    public void testTotalDoCarrinho() throws Exception {
        Pizza pizza2ingredientes = new Pizza();
        pizza2ingredientes.adicionaIngrediente("muzzarela");
        pizza2ingredientes.adicionaIngrediente("tomate");

        Pizza pizza6ingredientes = new Pizza();
        pizza6ingredientes.adicionaIngrediente("muzzarela");
        pizza6ingredientes.adicionaIngrediente("tomate");
        pizza6ingredientes.adicionaIngrediente("presunto");
        pizza6ingredientes.adicionaIngrediente("ovo");
        pizza6ingredientes.adicionaIngrediente("oregano");
        pizza6ingredientes.adicionaIngrediente("manjericão");


        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarPizza(pizza2ingredientes);
        carrinho.adicionarPizza(pizza6ingredientes);

        assertEquals(38, carrinho.totalDoCarrinho());
    }
}