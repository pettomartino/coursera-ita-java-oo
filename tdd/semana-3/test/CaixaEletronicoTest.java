import exceptions.ProblemaAoLerCartaoException;
import exceptions.ProblemaAoLerEnvelope;
import interfaces.Hardware;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by petto on 6/14/16.
 */
public class CaixaEletronicoTest {

    CaixaEletronico caixaEletronico;
    MockHardware hardware;

    @Before
    public void instanciaCaixaEletronica() {

        this.caixaEletronico = new CaixaEletronico();
        this.hardware = new MockHardware();
    }


    @Test
    public void mensagemDoSaldoCorreta() throws Exception
    {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(300));

        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);

        assertEquals("O saldo é R$ 300,00", caixaEletronico.saldo());
    }

    @Test
    public void mensagemSaqueComSaldo() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(300));
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);

        assertEquals("Retire seu dinheiro", caixaEletronico.sacar(new BigDecimal(200)));
    }

    @Test(expected = ProblemaAoLerCartaoException.class)
    public void mensagemSaqueComSaldoProblemaNoHardware() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(300));
        hardware.setProblemaAoLerCartaoException(true);
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);
        caixaEletronico.sacar(new BigDecimal(400));
    }

    @Test
    public void mensagemSaqueSemSaldo() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(300));
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);

        assertEquals("Saldo Insuficiente", caixaEletronico.sacar(new BigDecimal(400)));
    }

    @Test
    public void mensagemDeposito() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(200));
        MockServicoExterno servicoExterno = new MockServicoExterno(contaCorrenteMock);

        caixaEletronico.setServicoExterno(servicoExterno, hardware);

        assertEquals("Depósito recebido com sucesso.", caixaEletronico.depositar(new BigDecimal(100)));
    }

    @Test(expected = ProblemaAoLerEnvelope.class)
    public void mensagemDepositoComFalha() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(200));
        hardware.setProblemaAoLerEnvelope(true);
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);
        caixaEletronico.depositar(new BigDecimal(100));
    }

    @Test
    public void mensagemDepositoComFalhaNaoChamarPersistir() throws Exception {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(200));
        MockServicoExterno servicoExterno = new MockServicoExterno(contaCorrenteMock);
        hardware.setProblemaAoLerEnvelope(true);
        caixaEletronico.setServicoExterno(servicoExterno, hardware);
        assertEquals(false, servicoExterno.chamouPersistirConta);
    }



    @Test
    public void mensagemLogin() {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(200));
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);
        assertEquals("Usuário Autenticado.", caixaEletronico.login());
    }

    @Test
    public void mensagemFalhandoLogin() {
        ContaCorrenteMock contaCorrenteMock = new ContaCorrenteMock(new BigDecimal(200));
        hardware.setProblemaAoLerCartaoException(true);
        caixaEletronico.setServicoExterno(new MockServicoExterno(contaCorrenteMock), hardware);
        assertEquals("Não foi possível autenticar o usuário", caixaEletronico.login());
    }


}