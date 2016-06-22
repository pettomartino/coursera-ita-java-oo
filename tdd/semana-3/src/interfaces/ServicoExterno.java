package interfaces;

/**
 * Created by petto on 6/14/16.
 */
public interface ServicoExterno {
    ContaCorrente recuperarConta(String numeroDaConta);
    void persistirConta();

}
