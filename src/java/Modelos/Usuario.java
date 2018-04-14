
package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
