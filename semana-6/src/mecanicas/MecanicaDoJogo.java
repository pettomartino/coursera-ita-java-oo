package mecanicas;

/**
 * Created by petto on 4/9/16.
 */
public interface MecanicaDoJogo {

    String proximaPalavra();
    boolean verificaSeOJogoContinua();
    boolean verificaResposta(String resposta);
    int getVidas();
    String getMensagem();
//    int contabilizaPontos();
}
