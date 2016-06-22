import interfaces.ContaCorrente;
import interfaces.ServicoExterno;

/**
 * Created by petto on 6/14/16.
 */
public class MockServicoExterno  implements ServicoExterno {

    public ContaCorrente conta;
    public MockServicoExterno(ContaCorrente conta) {
        this.conta = conta;
    }

    @Override
    public ContaCorrente recuperarConta(String numeroDaConta) {
        return conta;
    }

    public boolean chamouPersistirConta = false;
    @Override
    public void persistirConta() {
        chamouPersistirConta = true;
    }
}
