package itacoursera;

/**
 * Created by petto on 3/25/16.
 */
public class Produto {
    private String nome;
    private int codigo;
    private double preco;

    public Produto(String nome, int codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }


    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return (hashCode() == produto.hashCode());
    }

    @Override
    public int hashCode() {
        return 37 * codigo;
    }
}
