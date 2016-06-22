import interfaces.ContaCorrente;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by petto on 6/14/16.
 */
public class ContaCorrenteMock implements ContaCorrente {

    private BigDecimal saldo;

    public ContaCorrenteMock(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String saldo() {
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);

        return String.format("O saldo é %s", numberFormat.format(saldo));
    }

    @Override
    public boolean sacar(BigDecimal valor) {
        return saldo.subtract(valor).intValue() > 0;
    }

    @Override
    public String depositar(BigDecimal valor) {
        return "Depósito recebido com sucesso.";
    }
}
