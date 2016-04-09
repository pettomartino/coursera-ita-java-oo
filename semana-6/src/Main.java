import embaralhadores.Embaralhador;
import embaralhadores.FabricaEmbaralhador;
import mecanicas.BancoDePalavras;
import mecanicas.FabricaMecanicaDoJogo;
import mecanicas.MecanicaDoJogo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MecanicaDoJogo mecanicaDoJogo = new FabricaMecanicaDoJogo().getMecanicaDoJogo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - - > BEM VINDO AO JOGO DE EMBARALHAR PALAVRAS < - - - -");
        System.out.print("\n\n");

        do {

            String palavra = mecanicaDoJogo.proximaPalavra();

            System.out.print("QUAL A PALAVRA CORRETA: ");
            System.out.print(palavra);
            System.out.println(" (" + mecanicaDoJogo.getVidas() + " vidas)");

            String resposta = scanner.next();
            mecanicaDoJogo.verificaResposta(resposta);

        } while (mecanicaDoJogo.verificaSeOJogoContinua());

        System.out.println(mecanicaDoJogo.getMensagem());
    }
}
