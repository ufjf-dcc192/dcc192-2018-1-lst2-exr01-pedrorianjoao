package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListaDeUsuario {

    private static List<Usuario> usuarios;

    public static List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
            ArrayList<ArrayList<FigurasDoAlbum>> albuns = new ArrayList();
            for (int i = 0; i < 4; i++) {
                albuns.add(new ArrayList());
            }
            for (ArrayList<FigurasDoAlbum> album : albuns) {
                Random random = new Random();
                for (int i = 0; i < ListaDeFigurinhas.getFigurinhas().size(); i++) {
                    FigurasDoAlbum figuras = new FigurasDoAlbum(ListaDeFigurinhas.getFigurinhas().get(i), random.nextInt(10));
                    album.add(figuras);
                }
            }
            usuarios.add(new Usuario("José", albuns.get(0)));
            usuarios.add(new Usuario("Maria", albuns.get(1)));
            usuarios.add(new Usuario("Rian", albuns.get(2)));
            usuarios.add(new Usuario("Pedro", albuns.get(3)));
        }

        return usuarios;
    }
}
