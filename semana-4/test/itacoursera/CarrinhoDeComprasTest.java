package itacoursera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 3/25/16.
 */
public class CarrinhoDeComprasTest {

    @Test
    public void testAdicionaProdutosDiferentes() throws Exception {
        Produto iphone_plus = new Produto("iphone", 1, 2000.00);
        ProdutoComTamanho iphone = new ProdutoComTamanho("iphone", 1, 2000.00, 2);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone_plus, 1);
        carrinho.adicionaProduto(iphone, 1);

        assertEquals(2, carrinho.quantidadeProdutosNoCarrinho());
    }

    @Test
    public void testAdicionaProdutoTamanhosDiferentes() throws Exception {
        ProdutoComTamanho iphone_plus = new ProdutoComTamanho("iphone", 1, 2000.00, 10);
        ProdutoComTamanho iphone = new ProdutoComTamanho("iphone", 1, 2000.00, 2);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone_plus, 1);
        carrinho.adicionaProduto(iphone, 1);

        assertEquals(2, carrinho.quantidadeProdutosNoCarrinho());
    }

    @Test
    public void testAdicionaProdutoTamanhosIguais() throws Exception {
        ProdutoComTamanho iphone_plus = new ProdutoComTamanho("iphone", 1, 2000.00, 1);
        ProdutoComTamanho iphone = new ProdutoComTamanho("iphone", 1, 2000.00, 1);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone_plus, 1);
        carrinho.adicionaProduto(iphone, 1);

        assertEquals(1, carrinho.quantidadeProdutosNoCarrinho());
    }

    @Test
    public void testRemoveProduto() throws Exception {
        Produto iphone = new Produto("iphone", 1, 2000.00);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone, 10);
        carrinho.removeProduto(iphone, 2);

        assertEquals(16000, carrinho.calculaTotal(), 0.00);
    }

    @Test
    public void testRemoveProdutoTamanhosDiferentes() throws Exception {
        ProdutoComTamanho iphone = new ProdutoComTamanho("iphone", 1, 2000.00, 1);
        ProdutoComTamanho iphone_plus = new ProdutoComTamanho("iphone plus", 1, 2000.00, 2);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone, 1);
        carrinho.adicionaProduto(iphone_plus, 1);
        carrinho.removeProduto(iphone, 1);

        assertEquals(1, carrinho.quantidadeProdutosNoCarrinho());
    }

    @Test
    public void testCalculaTotal() throws  Exception {
        Produto iphone_1 = new Produto("iphone", 1, 2000.00);
        Produto iphone_2 = new Produto("iphone", 1, 2000.00);
        ProdutoComTamanho android_1 = new ProdutoComTamanho("android", 4, 1200.50, 2);
        ProdutoComTamanho android_2 = new ProdutoComTamanho("android", 4, 1200.50, 2);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaProduto(iphone_1, 1);
        carrinho.adicionaProduto(iphone_2, 2);
        carrinho.adicionaProduto(android_1, 3);
        carrinho.adicionaProduto(android_2, 1);

        assertEquals(10802, carrinho.calculaTotal(), 0.00);
    }
}