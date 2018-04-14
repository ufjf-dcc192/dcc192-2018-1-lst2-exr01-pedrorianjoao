package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rian das Dores Alves 201676040
 */
public class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private ArrayList<Map<Integer, Figurinha>> mapaQtdFig = new ArrayList<>();

    public Usuario(int idUsuario, String nomeUsuario, ArrayList<Figurinha> lstFigurinhas) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;

    }

    //mapaNomes.put(1, "João Delfino");
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public ArrayList<Map<Integer, Figurinha>> getMapaQtdFig() {
        return mapaQtdFig;
    }

    public void setMapaQtdFig(ArrayList<Map<Integer, Figurinha>> mapaQtdFig) {
        this.mapaQtdFig = mapaQtdFig;
    }
}
