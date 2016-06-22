import exceptions.ProblemaAoEntregarDinheiroException;
import exceptions.ProblemaAoLerCartaoException;
import exceptions.ProblemaAoLerEnvelope;
import interfaces.ContaCorrente;
import interfaces.Hardware;
import interfaces.ServicoExterno;

import java.math.BigDecimal;

/**
 * Created by petto on 6/14/16.
 */
public class CaixaEletronico {
    private ServicoExterno servicoExterno;
    private Hardware hardware;

    public void setServicoExterno(ServicoExterno servicoExterno, Hardware hardware) {
        this.servicoExterno = servicoExterno;
        this.hardware = hardware;
    }

    public String saldo() throws ProblemaAoLerCartaoException {
        return contaCorrente().saldo();
    }

    public String sacar(BigDecimal valor) throws ProblemaAoLerCartaoException, ProblemaAoEntregarDinheiroException {
        if(contaCorrente().sacar(valor)) {
            hardware.entregarDinheiro();
            servicoExterno.persistirConta();
            return "Retire seu dinheiro";
        }

        return "Saldo Insuficiente";
    }

    public String depositar(BigDecimal valor) throws ProblemaAoLerEnvelope, ProblemaAoLerCartaoException{
        contaCorrente().depositar(valor);
        lerEnvelope();
        servicoExterno.persistirConta();

        return "Depósito recebido com sucesso.";
    }

    public String login() {
        try {
            recuperaNumeroDaConta();
            return "Usuário Autenticado.";
        } catch (Exception e) {
            return "Não foi possível autenticar o usuário";
        }

    }

    private ContaCorrente contaCorrente() throws ProblemaAoLerCartaoException{
        String numeroDaConta = recuperaNumeroDaConta();
        return this.servicoExterno.recuperarConta(numeroDaConta);
    }

    private void lerEnvelope() throws ProblemaAoLerEnvelope {
        this.hardware.lerEnvelope();
    }

    private String recuperaNumeroDaConta() throws ProblemaAoLerCartaoException {
        return this.hardware.pegarNumeroDaContaCartao();
    }


}
