
package Modelos;

import java.util.List;

public class ListaDeFigurinhas {
    private static List<Figurinha> figurinhas;

    public static List<Figurinha> getFigurinhas() {
        if(figurinhas == null){
            figurinhas.add(new Figurinha(0,"Mascote da Copa"));
            figurinhas.add(new Figurinha(1,"Logo da copa - Top"));
            figurinhas.add(new Figurinha(2,"Logo da copa - Bottom"));
            figurinhas.add(new Figurinha(3,"Bola da copa"));
        }
        
        return figurinhas;
    }

}
