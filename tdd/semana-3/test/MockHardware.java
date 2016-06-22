import exceptions.ProblemaAoEntregarDinheiroException;
import exceptions.ProblemaAoLerCartaoException;
import exceptions.ProblemaAoLerEnvelope;
import interfaces.Hardware;

/**
 * Created by petto on 6/21/16.
 */
public class MockHardware implements Hardware{

    private boolean _problemaAoLerCartaoException = false;
    private boolean _problemaAoEntregarDinheiroException = false;
    private boolean _problemaAoLerEnvelope = false;

    public void setProblemaAoLerCartaoException(boolean retornar) {
        this._problemaAoLerCartaoException = retornar;
    }
    public void setProblemaAoEntregarDinheiroException(boolean retornar) {
        this._problemaAoEntregarDinheiroException = retornar;
    }
    public void setProblemaAoLerEnvelope(boolean retornar) {
        this._problemaAoLerEnvelope = retornar;
    }

    @Override
    public String pegarNumeroDaContaCartao() throws ProblemaAoLerCartaoException {
        if (_problemaAoLerCartaoException) {
            throw new ProblemaAoLerCartaoException();
        }
        return "123456";
    }

    @Override
    public void entregarDinheiro() throws ProblemaAoEntregarDinheiroException {
        if (_problemaAoEntregarDinheiroException) {
            throw new ProblemaAoEntregarDinheiroException();
        }
    }

    @Override
    public void lerEnvelope() throws ProblemaAoLerEnvelope {
        if (_problemaAoLerEnvelope) {
            throw new ProblemaAoLerEnvelope();
        }
    }
}
