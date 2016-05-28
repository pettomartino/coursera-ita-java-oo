package embaralhadores;

/**
 * Created by petto on 4/9/16.
 */
public class EmbaralhadorBasico implements Embaralhador{


    public String embaralharPalavra(String palavra) {
        StringBuilder stringBuilder = new StringBuilder();

        String[] words = palavra.split("");

        for (int i = words.length-1; i >= 0; i--) {
            String currentWord = words[i];
            if (i-1 >= 0) {
                String nextWord = words[--i];
                stringBuilder.append(nextWord);
            }
            stringBuilder.append(currentWord);
        }
        return stringBuilder.toString();
    }
}
