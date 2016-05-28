package embaralhadores;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/9/16.
 */
public class EmbaralhadorRandomicoTest {

    @Test
    public void testEmbaralharPalavraResultadoIgual() throws Exception {
        EmbaralhadorRandomico embaralhadorBasico = new EmbaralhadorRandomico();
        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra("mel");
        List<String> possiveisPalavras = Arrays.asList(new String[] { "elm", "lem", "mle", "eml", "lme" });

        assertEquals(true, possiveisPalavras.contains(palavraEmbaralhada));
    }
    @Test
    public void testEmbaralharPalavraResultadoDiferente() throws Exception {
        EmbaralhadorRandomico embaralhadorBasico = new EmbaralhadorRandomico();

        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra("radio");

        assertNotEquals("radio", palavraEmbaralhada);
    }

    @Test
    public void testEmbaralharPalavraTamanhoIgual() throws Exception {
        String palavraOriginal = "presidente";
        EmbaralhadorRandomico embaralhadorBasico = new EmbaralhadorRandomico();
        String palavraEmbaralhada = embaralhadorBasico.embaralharPalavra(palavraOriginal);

        assertEquals(palavraOriginal.length(), palavraEmbaralhada.length());
    }
}