import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/2/16.
 */
public class ComTituloTest {

    @Test
    public void testFormatarNome() throws Exception {
        ComTitulo comTitulo = new ComTitulo("Excelentíssimo");

        String exercicio = comTitulo.formatarNome("João", "do Pulo");

        assertEquals("Excelentíssimo João do Pulo", exercicio);
    }
}