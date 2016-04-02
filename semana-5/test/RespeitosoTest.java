import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/2/16.
 */
public class RespeitosoTest {
    @Test
    public void testFormatarNomeFeminino() throws Exception {
        Respeitoso respeitoso = new Respeitoso(Sexo.Feminino);

        String exercicio = respeitoso.formatarNome("Fernanda", "Catifunda");

        assertEquals("Sra. Catifunda", exercicio);

    }

    @Test
    public void testFormatarNomeMasculino() throws Exception {
        Respeitoso respeitoso = new Respeitoso(Sexo.Masculino);

        String exercicio = respeitoso.formatarNome("João", "Matarazzo");

        assertEquals("Sr. Matarazzo", exercicio);

    }

}