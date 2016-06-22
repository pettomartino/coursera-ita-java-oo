package interfaces;

import java.math.BigDecimal;

/**
 * Created by petto on 6/14/16.
 */
public interface ContaCorrente {
    String saldo();
    boolean sacar(BigDecimal valor);
    String depositar(BigDecimal valor);
}
