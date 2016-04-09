package embaralhadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by petto on 4/9/16.
 */
public class FabricaEmbaralhador {
    private List<Embaralhador> embaralhadores;

    public FabricaEmbaralhador() {
        embaralhadores = new ArrayList<>();
//        embaralhadores.add(new EmbaralhadorBasico());
        embaralhadores.add(new EmbaralhadorRandomico());
    }

    public FabricaEmbaralhador(List<Embaralhador> embaralhadores) {
        this.embaralhadores = embaralhadores;
    }

    public Embaralhador getEmbaralhador() {
        int randomItem = new Random().nextInt(embaralhadores.size());
        return embaralhadores.get(randomItem);
    }

}
