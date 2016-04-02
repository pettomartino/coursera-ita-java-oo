import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/2/16.
 */
public class AutoridadeTest {

    @Test
    public void testGetTratamentoInformal() throws Exception {
        Autoridade autoridade = new Autoridade("João", "do Pulo", new Informal());

        String exercicio = autoridade.getTratamento();

        assertEquals("João", exercicio);
    }

    @Test
    public void testGetTratamentoRespeitoso() throws Exception {
        Respeitoso formatadorRespeitoso = new Respeitoso(Sexo.Masculino);
        Autoridade autoridade = new Autoridade("João", "do Pulo", formatadorRespeitoso);

        String exercicio = autoridade.getTratamento();

        assertEquals("Sr. do Pulo", exercicio);
    }

    @Test
    public void testGetTratamentoComTitulo() throws Exception {
        ComTitulo formatadorComTitulo = new ComTitulo("Professor");
        Autoridade autoridade = new Autoridade("João", "do Pulo", formatadorComTitulo);

        String exercicio = autoridade.getTratamento();

        assertEquals("Professor João do Pulo", exercicio);
    }
}