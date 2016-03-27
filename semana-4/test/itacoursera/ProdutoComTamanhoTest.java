package itacoursera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 3/25/16.
 */
public class ProdutoComTamanhoTest {

    @Test
    public void testEqualsMesmoTamanho() throws Exception {
        ProdutoComTamanho pt1 = new ProdutoComTamanho("Android1", 1, 200, 1);
        ProdutoComTamanho pt2 = new ProdutoComTamanho("Android2", 1, 2500, 1);

        assertEquals(pt1, pt2);
    }

    @Test
    public void testEqualsTamanhosDiferentes() throws Exception {
        ProdutoComTamanho pt1 = new ProdutoComTamanho("Android1", 1, 1000, 1);
        ProdutoComTamanho pt2 = new ProdutoComTamanho("Android2", 1, 2500, 2);

        assertNotEquals(pt1, pt2);
    }

    @Test
    public void testHashCodeProdutoMesmoTamanho() throws Exception {
        ProdutoComTamanho pt1 = new ProdutoComTamanho("Iphone 5C", 1, 1000, 1);
        ProdutoComTamanho pt2 = new ProdutoComTamanho("Iphone 4S", 1, 600, 1);

        assertEquals(pt1.hashCode(), pt2.hashCode());
    }

    @Test
    public void testHashCodeProdutoTamanhoDiferente() throws Exception {
        ProdutoComTamanho pt1 = new ProdutoComTamanho("Xperia Z3", 1, 2400, 1);
        ProdutoComTamanho pt2 = new ProdutoComTamanho("Xperia Z3", 1, 2400, 2);

        assertNotEquals(pt1.hashCode(), pt2.hashCode());
    }
}