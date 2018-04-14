
package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rian das Dores Alves 201676040
 */
public class Usuario {
    
    int idUsuario; 
    String nomeUsuario;
    ArrayList<Map<Integer, Figurinha>> mapaQtdFig = new ArrayList<>();

    public Usuario(int idUsuario, String nomeUsuario, ArrayList<Figurinha> lstFigurinhas) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
           
    }
    
    
    
    //mapaNomes.put(1, "João Delfino");
}
