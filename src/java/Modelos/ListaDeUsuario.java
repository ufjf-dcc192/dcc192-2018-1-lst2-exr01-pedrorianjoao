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
            ArrayList<ArrayList<Map<Integer, Figurinha>>> mapasTotais = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                 mapasTotais.add(new ArrayList<>());
            }
            for (ArrayList<Map<Integer, Figurinha>> mapasT : mapasTotais) {
                Random random = new Random();
                for (int i = 0; i < ListaDeFigurinhas.getFigurinhas().size(); i++) {
                    Map<Integer, Figurinha> mapa = new HashMap<>();
                    mapa.put(random.nextInt(10), ListaDeFigurinhas.getFigurinhas().get(i));
                    mapasT.add(mapa);
                }
            }

            usuarios.add(new Usuario(0, "José", mapasTotais.get(0)));
            usuarios.add(new Usuario(1, "Maria", mapasTotais.get(1)));
            usuarios.add(new Usuario(2, "Rian", mapasTotais.get(2)));
            usuarios.add(new Usuario(3, "Pedro", mapasTotais.get(3)));
        }

        return usuarios;
    }
}
