import com.sun.tools.classfile.InnerClasses_attribute;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by petto on 4/2/16.
 */
public class InformalTest {

    @Test
    public void testFormatarNome() throws Exception {
        Informal informal = new Informal();

        String exercicio = informal.formatarNome("Fernando", "Machado");

        assertEquals("Fernando", exercicio);
    }

    @Test
    public void testFormatarNomeErrado() throws Exception {
        Informal informal = new Informal();

        String exercicio = informal.formatarNome("Fernando", "Machado");

        assertNotEquals("Machado", exercicio);
    }
}