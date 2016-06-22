package semana1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by petto on 5/28/16.
 */
public class Conversor {

    final private static String regex =  "(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|(?<=[0-9])(?=[A-Z][a-z])|(?<=[a-zA-Z])(?=[0-9])";

    public static List<String> converterCamelCase(String text) throws InvalidException {
        if (!isValid(text))
            throw new InvalidException("Encontra");

        return toLower(text.split(regex));
    }

    private static Boolean isValid(String text) {
        if (text.matches("^[0-9].*") || text.matches(".*[^a-zA-Z0-9].*"))
            return false;

        return true;
    }

    private static List<String> toLower(String[] words) {
        List<String> lowerWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].matches("[A-Z]{2,}")) {
                lowerWords.add(words[i]);
            } else {
                lowerWords.add(words[i].toLowerCase());
            }
        }
        return lowerWords;
    }
}
