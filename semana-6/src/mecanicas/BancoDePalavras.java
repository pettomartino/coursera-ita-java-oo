package mecanicas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by petto on 4/9/16.
 */
enum Palavras {
    Dificil,
    Facil
}
public class BancoDePalavras {

    private List<String> palavrasJaUsadas = new ArrayList<>();

    private List<String> words = new ArrayList<>();

    public BancoDePalavras(Palavras palavras) {
        String arquivo = palavras == Palavras.Facil ? "palavras-faceis.txt" : "palavras-dificeis.txt";
        try {
            carregaPalavrasDoArquivo(arquivo);
        } catch (Exception e) {
            carregaPalavrasBasicas();
        }
    }

    private void carregaPalavrasDoArquivo(String arquivo) throws FileNotFoundException {
        Scanner palavrasDoArquivo = new Scanner(new File(arquivo)).useDelimiter("\n");

        while (palavrasDoArquivo.hasNext()) {
            words.add(palavrasDoArquivo.next());
        }
        palavrasDoArquivo.close();
    }

    private void carregaPalavrasBasicas() {
        words.add("Paralelepipedo");
        words.add("Abacateiro");
        words.add("Melância");
        words.add("Sabonete");
        words.add("pato");
        words.add("osmose");
        words.add("churrasco");
        words.add("penteadeira");
        words.add("almondega");
        words.add("molusco");
    }

    public String getPalavra() {
        if (palavrasJaUsadas.size() == words.size()) {
            return null;
        }

        int index = new Random().nextInt(words.size());
        String palavraSelecionada = words.get(index);

        if (palavrasJaUsadas.contains(palavraSelecionada)) {
            return getPalavra();
        }
        palavrasJaUsadas.add(palavraSelecionada);

        return palavraSelecionada.toLowerCase();
    }

}
