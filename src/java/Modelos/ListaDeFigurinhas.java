
package Modelos;

import java.util.ArrayList;
import java.util.List;

public class ListaDeFigurinhas {
    private static List<Figurinha> figurinhas;

    public static List<Figurinha> getFigurinhas() {
        if(figurinhas == null){
            figurinhas = new ArrayList<>();
            figurinhas.add(new Figurinha(0,"Mascote da Copa"));
            figurinhas.add(new Figurinha(1,"Logo da copa - Top"));
            figurinhas.add(new Figurinha(2,"Logo da copa - Bottom"));
            figurinhas.add(new Figurinha(3,"Bola da copa"));
            figurinhas.add(new Figurinha(4,"Taça da copa"));
            figurinhas.add(new Figurinha(5,"Estádio Sochi"));
            figurinhas.add(new Figurinha(6,"Estadio Kramlin"));
        }
        
        return figurinhas;
    }

}
