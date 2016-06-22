import junit.framework.TestCase;
import org.junit.Test;
import semana1.Conversor;
import semana1.InvalidException;
import java.util.List;

/**
 * Created by petto on 5/28/16.
 */
public class ConversorTest extends TestCase {

    @Test
    public void testNomeMinusculo() throws Exception {
        List<String> strings = Conversor.converterCamelCase("nome");

        assertEquals(1, strings.size());
        assertEquals("nome", strings.get(0));
    }

    @Test
    public void testNomeMaiusculo() throws Exception {
        List<String> string = Conversor.converterCamelCase("Nome");

        assertEquals(1, string.size());
        assertEquals("nome", string.get(0));
    }

    @Test
    public void testNomeComposto() throws Exception {
        List<String> string = Conversor.converterCamelCase("nomeComposto");

        assertEquals(2, string.size());
        assertEquals("nome", string.get(0));
        assertEquals("composto", string.get(1));
    }

    @Test
    public void testNomeComposto2() throws Exception {
        List<String> string = Conversor.converterCamelCase("NomeComposto");

        assertEquals(2, string.size());
        assertEquals("nome", string.get(0));
        assertEquals("composto", string.get(1));
    }

    @Test
    public void testSigla() throws Exception {
        List<String> string = Conversor.converterCamelCase("CPF");

        assertEquals(1, string.size());
        assertEquals("CPF", string.get(0));
    }

    @Test
    public void testNomeComSigla() throws Exception {
        List<String> string = Conversor.converterCamelCase("numeroCPF");

        assertEquals(2, string.size());
        assertEquals("numero", string.get(0));
        assertEquals("CPF", string.get(1));
    }

    @Test
    public void testNomeComSiglaNome() throws Exception {
        List<String> string = Conversor.converterCamelCase("numeroCPFContribuinte");

        assertEquals(3, string.size());
        assertEquals("numero", string.get(0));
        assertEquals("CPF", string.get(1));
        assertEquals("contribuinte", string.get(2));
    }

    @Test
    public void testNomeNumeroNome() throws Exception {
        List<String> string = Conversor.converterCamelCase("recupera10Primeiros");

        assertEquals(3, string.size());
        assertEquals("recupera", string.get(0));
        assertEquals("10", string.get(1));
        assertEquals("primeiros", string.get(2));
    }


    public void testFalhaComecaComNumero()  {
        try {
            Conversor.converterCamelCase("10Primeiros");
            fail();
        } catch (InvalidException e) { }
    }

    public void testFalhaComCaracterInvalido() {
        try {
            Conversor.converterCamelCase("nome#Composto");
            fail();
        } catch (InvalidException e) {}

    }


}