package embaralhadores;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/9/16.
 */
public class EmbaralhadorBasicoTest {

    @Test
    public void testEmbaralharPalavraResultadoDiferente() throws Exception {
        EmbaralhadorBasico embaralhadorBasico = new EmbaralhadorBasico();

        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra("teste");

        assertNotEquals("teste", palavraEmbaralhada);
    }

    @Test
    public void testEmbaralharPalavraTamanhoIgual() throws Exception {
        String palavraOriginal = "paralelepipedo";
        EmbaralhadorBasico embaralhadorBasico = new EmbaralhadorBasico();
        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra(palavraOriginal);

        assertEquals(palavraOriginal.length(), palavraEmbaralhada.length());
    }


    @Test
    public void testEmbaralharPalavraResultadoIgual() throws Exception {
        EmbaralhadorBasico embaralhadorBasico = new EmbaralhadorBasico();
        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra("jabuticaba");

        assertEquals("bacatibuja", palavraEmbaralhada);
    }
}