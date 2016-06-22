package interfaces;

import exceptions.ProblemaAoEntregarDinheiroException;
import exceptions.ProblemaAoLerCartaoException;
import exceptions.ProblemaAoLerEnvelope;

/**
 * Created by petto on 6/14/16.
 */
public interface Hardware {
    String pegarNumeroDaContaCartao() throws ProblemaAoLerCartaoException;
    void entregarDinheiro() throws ProblemaAoEntregarDinheiroException;
    void lerEnvelope() throws ProblemaAoLerEnvelope;


}
