import java.util.HashMap;
import java.util.Map;

/**
 * Created by petto on 3/12/16.
 */
public class Pizza {

    static HashMap<String, Integer> ingredientesTotais = new HashMap();
    HashMap<String, Integer> ingredientesDaPizza = new HashMap();

    void adicionaIngrediente(String ingrediente) {
        int ingredientesDaPizza = this.ingredientesDaPizza.getOrDefault(ingrediente, 0);
        this.ingredientesDaPizza.put(ingrediente, ++ingredientesDaPizza);

        contabilizaIngrediente(ingrediente);
    }

    static void contabilizaIngrediente(String ingrediente) {
        int ingredientesTotais = Pizza.ingredientesTotais.getOrDefault(ingrediente, 0);
        Pizza.ingredientesTotais.put(ingrediente, ++ingredientesTotais);
    }

    static void zerarIngredientes() {
        Pizza.ingredientesTotais.clear();
    }

    int totalIgredientesDaPizza() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : ingredientesDaPizza.entrySet()) {
            total += entry.getValue();
        }
        return total;

    }

    int getPreco() {
        int total = totalIgredientesDaPizza();

        if (total <= 2) {
            return 15;
        } else if (total >= 3 && total <= 5) {
            return 20;
        }
        return 22;
    }
}
