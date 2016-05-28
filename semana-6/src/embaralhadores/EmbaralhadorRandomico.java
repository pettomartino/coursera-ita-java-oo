package embaralhadores;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by petto on 4/9/16.
 */
public class EmbaralhadorRandomico implements Embaralhador {

    private String palavaOriginal;

    public String embaralharPalavra(String palavra) {
        palavaOriginal = palavaOriginal;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> letras = new ArrayList<>(Arrays.asList(palavra.split("")));

        while(stringBuilder.length() < palavra.length()) {

            int indice = new Random().nextInt(letras.size());
            stringBuilder.append(letras.remove(indice));
        }

        return stringBuilder.reverse().toString();
    }

}
