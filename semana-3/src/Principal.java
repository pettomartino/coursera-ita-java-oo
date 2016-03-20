import java.util.Map;

public class Principal {

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza();
        pizza1.adicionaIngrediente("tomate");
        pizza1.adicionaIngrediente("presunto");
        pizza1.adicionaIngrediente("mussarela");

        Pizza pizza2 = new Pizza();
        pizza2.adicionaIngrediente("beringela");
        pizza2.adicionaIngrediente("mussarela");

        Pizza pizza3 = new Pizza();
        pizza3.adicionaIngrediente("tomate");
        pizza3.adicionaIngrediente("catupiry");
        pizza3.adicionaIngrediente("calabreza");
        pizza3.adicionaIngrediente("mussarela");

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarPizza(pizza1);
        carrinho.adicionarPizza(pizza2);
        carrinho.adicionarPizza(pizza3);

        System.out.println("Preço da pizza1: " + pizza1.getPreco());
        System.out.println("Preço da pizza2: " + pizza2.getPreco());
        System.out.println("Preço da pizza3: " + pizza3.getPreco());

        System.out.println("Total do carrinho: "+ carrinho.totalDoCarrinho());

        System.out.println("Igredientes utilizados e quantidades");

        for (Map.Entry<String, Integer> igrediente : Pizza.ingredientesTotais.entrySet()) {
            System.out.println("Igrediente: "+ igrediente.getKey() + " quantidade: " + igrediente.getValue());
        }
    }
}
