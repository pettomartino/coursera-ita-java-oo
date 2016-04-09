package mecanicas;

import embaralhadores.Embaralhador;
import embaralhadores.FabricaEmbaralhador;

/**
 * Created by petto on 4/9/16.
 */
public class JogoDificil implements MecanicaDoJogo {
    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private String palavraDaVez;
    private int vidas = 5;
    private boolean errou = false;
    private String mensagem;
    public JogoDificil() {
        bancoDePalavras = new BancoDePalavras(Palavras.Dificil);
    }

    public String proximaPalavra() {
        if (palavraDaVez != null) {
            return embaralhador.embaralharPalavra(palavraDaVez);
        }

        embaralhador = fabricaEmbaralhador();
        palavraDaVez = bancoDePalavras.getPalavra();
        if (palavraDaVez != null) {
            return embaralhador.embaralharPalavra(palavraDaVez);
        }
        return null;
    }

    public String regras() {
        StringBuilder regras = new StringBuilder();
        regras.append("- O Banco de Palavras escolhidos são de palavras raras.");
        regras.append("- Os embaralhadores podem mudar a cada nova palavra.\n");
        regras.append("- Você possui 5 vidas mas NÃO PODE cometer erros seguidos.");

        return regras.toString();
    }

    public boolean verificaSeOJogoContinua() {
        if (!possuiVidas()) {
            setMensagem("=( acabaram as vidas!. O Jogo acabou!");
            return false;
        } else if (possuiErrosSeguidos()) {
            setMensagem("Você errou a jogada anterior, não pode mais errar");
            return false;
        } else if (proximaPalavra() == null) {
            setMensagem("INCRÍVEL!!!! Você venceu a máquina. Não existem mais palavras.");
            return false;
        }

        return true;
    }

    private boolean possuiVidas() {
        return vidas > 0;
    }

    private boolean possuiErrosSeguidos() {
        return errou;
    }

    private Embaralhador fabricaEmbaralhador() {
        return new FabricaEmbaralhador().getEmbaralhador();
    }


    public boolean verificaResposta(String resposta) {
        boolean respostaCerta = resposta.toLowerCase().equals(palavraDaVez);

        finalizaRodada(respostaCerta);

        return respostaCerta;
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

    public int getVidas() {
        return vidas;
    }

}
