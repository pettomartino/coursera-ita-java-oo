import java.util.ArrayList;

/**
 * Created by petto on 3/12/16.
 */
public class CarrinhoDeCompras {

    ArrayList<Pizza> pizzas = new ArrayList<>();

    void adicionarPizza(Pizza pizza) {

        if(pizza.totalIgredientesDaPizza() > 0) {
            pizzas.add(pizza);
        }
    }

    int totalDePizzas() {
        return pizzas.size();
    }

    int totalDoCarrinho() {
        int precoTotal = 0;
        for(Pizza pizza : pizzas) {
            precoTotal += pizza.getPreco();
        }
        return precoTotal;
    }


}
