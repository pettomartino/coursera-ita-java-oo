package mecanicas;

import mecanicas.MecanicaDoJogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by petto on 4/9/16.
 */
public class FabricaMecanicaDoJogo {
    private List<MecanicaDoJogo> mecanicas;

    public FabricaMecanicaDoJogo() {
        mecanicas = new ArrayList<MecanicaDoJogo>();
        mecanicas.add(new JogoFacil());
    }

    public FabricaMecanicaDoJogo(List<MecanicaDoJogo> mecanicas) {
        this.mecanicas = mecanicas;
    }

    public MecanicaDoJogo getMecanicaDoJogo() {
        int randomItem = new Random().nextInt(mecanicas.size());
        return mecanicas.get(randomItem);
    }


}
