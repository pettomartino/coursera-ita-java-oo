import mecanicas.FabricaMecanicaDoJogo;
import mecanicas.MecanicaDoJogo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MecanicaDoJogo mecanicaDoJogo = new FabricaMecanicaDoJogo().getMecanicaDoJogo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - - > BEM VINDO AO JOGO DE EMBARALHAR PALAVRAS < - - - -");
        System.out.print("\n\n");
        System.out.println("REGRAS:");
        System.out.println(mecanicaDoJogo.regras());
        System.out.print("\n\n");

        do {

            String palavra = mecanicaDoJogo.proximaPalavra();

            System.out.print("QUAL A PALAVRA CORRETA: ");
            System.out.print(palavra);
            System.out.println(" (" + mecanicaDoJogo.getVidas() + " vidas)");

            String resposta = scanner.next();
            if(mecanicaDoJogo.verificaResposta(resposta)) {
                System.out.println("Resposta certa!");
            } else {
                System.out.println("Você errou!");
            }

        } while (mecanicaDoJogo.verificaSeOJogoContinua());

        System.out.println(mecanicaDoJogo.getMensagem());
    }

}
