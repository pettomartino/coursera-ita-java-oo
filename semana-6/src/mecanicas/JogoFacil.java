package mecanicas;

import embaralhadores.Embaralhador;
import embaralhadores.FabricaEmbaralhador;

/**
 * Created by petto on 4/9/16.
 */
public class JogoFacil implements MecanicaDoJogo {

    private Embaralhador embaralhador;
    private BancoDePalavras bancoDePalavras;
    private int vidas = 2;
    private String palavraDaVez;
    private String mensagem;

    public JogoFacil() {
        this.bancoDePalavras = new BancoDePalavras(Palavras.Facil);
        this.embaralhador = new FabricaEmbaralhador().getEmbaralhador();
    }

    public int getVidas() {
        return vidas;
    }

    public String proximaPalavra() {
        if (palavraDaVez == null) {
            palavraDaVez = bancoDePalavras.getPalavra();
        }

        if (palavraDaVez == null) {
            return null;
        }

        return embaralharPalavra(palavraDaVez);
    }

    private String embaralharPalavra(String palavra) {
        return embaralhador.embaralharPalavra(palavra);
    }

    public boolean verificaResposta(String resposta) {
        boolean respostaCerta = resposta.toLowerCase().equals(palavraDaVez);

        finalizaRodada(respostaCerta);

        return respostaCerta;
    }

    public boolean verificaSeOJogoContinua() {
        if (vidas < 1) {
            setMensagem("=( acabaram as vidas!. O Jogo acabou!");
            return false;
        } else if (proximaPalavra() == null) {
            setMensagem("INCRÍVEL!!!! Você venceu a máquina. Não existem mais palavras.");
            return false;
        }

        return true;
    }

    private void finalizaRodada(boolean respostaCerta) {
        palavraDaVez = null;

        if (!respostaCerta) {
            retiraVida();
        }
    }

    private void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    private void retiraVida() {
        --vidas;
    }
}
