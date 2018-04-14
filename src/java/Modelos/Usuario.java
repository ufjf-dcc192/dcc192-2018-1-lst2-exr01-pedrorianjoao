package Modelos;

import java.util.ArrayList;
import java.util.HashMap;


public class Usuario {

    private static int usuarios = 0;
    private int idUsuario;
    private String nomeUsuario;
    private ArrayList<FigurasDoAlbum> mapaQtdFig = new ArrayList<>();

    public Usuario(String nomeUsuario, ArrayList<FigurasDoAlbum> mapaQtdFig) {
        this.idUsuario = usuarios++;
        this.nomeUsuario = nomeUsuario;
        this.mapaQtdFig = mapaQtdFig;
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

    public ArrayList<FigurasDoAlbum> getMapaQtdFig() {
        return mapaQtdFig;
    }

    public void setMapaQtdFig(ArrayList<FigurasDoAlbum> mapaQtdFig) {
        this.mapaQtdFig = mapaQtdFig;
    }
}
