package itacoursera;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petto on 3/25/16.
 */
public class CarrinhoDeCompras {

    private Map<Produto, Integer> produtos = new HashMap<>();

    public void adicionaProduto(Produto produto, int quantidade) {
        int quantidadeNoCarrinho = produtos.getOrDefault(produto, 0);
        quantidadeNoCarrinho += quantidade;
        produtos.put(produto, quantidadeNoCarrinho);
    }

    public void removeProduto(Produto produto, int quantidade) {
        int quantidadeNoCarrinho = produtos.getOrDefault(produto, 0);
        quantidadeNoCarrinho -= quantidade;

        if (quantidadeNoCarrinho < 1) {
            produtos.remove(produto);
        } else {
            produtos.put(produto, quantidadeNoCarrinho);
        }
    }

    public int quantidadeProdutosNoCarrinho() {
        return produtos.size();
    }

    public double calculaTotal(){
        double total = 0;
        for(Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto p = entry.getKey();
            int quantidade = entry.getValue();

            total += p.getPreco() * quantidade;
        }
        return total;
    }
}
