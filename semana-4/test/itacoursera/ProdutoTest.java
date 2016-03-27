package itacoursera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 3/25/16.
 */
public class ProdutoTest {

    @Test
    public void testEqualsMesmoCodigo() throws Exception {
        Produto p1 = new Produto("Iphone 6S", 1, 5000);
        Produto p2 = new Produto("Iphone SE", 1, 1600);

        assertEquals(p1, p2);
    }

    @Test
    public void testEqualsCodigoDiferente() throws Exception {
        Produto p1 = new Produto("Iphone 6S", 1, 5000);
        Produto p2 = new Produto("Iphone SE", 2, 1600);

        assertNotEquals(p1, p2);
    }

    @Test
    public void testHashCodeCodigoDiferente() throws Exception {
        Produto p1 = new Produto("Iphone 6S", 1, 5000);
        Produto p2 = new Produto("Iphone SE", 2, 1600);

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testHashCodeCodigosIguais() throws Exception {
        Produto p1 = new Produto("Iphone 6S", 1, 5000);
        Produto p2 = new Produto("Iphone SE", 1, 1600);

        assertEquals(p1.hashCode(), p2.hashCode());
    }
}