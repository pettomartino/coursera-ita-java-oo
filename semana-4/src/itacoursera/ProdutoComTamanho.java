package itacoursera;

/**
 * Created by petto on 3/25/16.
 */
public class ProdutoComTamanho extends Produto {

    private int tamanho;

    public ProdutoComTamanho(String nome, int codigo, double preco, int tamanho) {
        super(nome, codigo, preco);
        this.tamanho = tamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProdutoComTamanho produtoComTamanho = (ProdutoComTamanho) o;

        return hashCode() == produtoComTamanho.hashCode();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + tamanho;
        return result;
    }
}
