package Servlets;

import Modelos.Figurinha;
import Modelos.ListaDeFigurinhas;
import Modelos.ListaDeUsuario;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario-listar.html", "/usuario-inserir.html", "/usuario-editar.html", "/usuario-excluir.html"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("/usuario-listar.html".equals(request.getServletPath())) {
            listarUsuario(response, request);
        } else if ("/usuario-novo.html".equals(request.getServletPath())) {
            criarFormUsuario(request, response);
        } else if ("/usuario-editar.html".equals(request.getServletPath())) {
            editarUsuario(request, response);
        } else if ("/usuario-excluir.html".equals(request.getServletPath())) {
            excluiUsuario(request, response);
        }
        response.sendError(404);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("operacao") == null) {
            response.setContentType("text/html;charset=UTF-8");
            String nome = request.getParameter("nome");
            ArrayList<Map<Integer, Figurinha>> mapaQtdFig = new ArrayList<>();
            Map<Integer, Figurinha> mapa = new HashMap<>();

            ArrayList<Figurinha> figurinhas = (ArrayList<Figurinha>) ListaDeFigurinhas.getFigurinhas();
            for (int i = 0; i < figurinhas.size(); i++) {
                if (request.getParameter(Integer.toString(figurinhas.get(i).getNumero())) != null) {
                    mapa.put(Integer.parseInt(request.getParameter(Integer.toString(figurinhas.get(i).getNumero()))), figurinhas.get(i));
                    mapaQtdFig.add(mapa);
                }
            }
            Usuario usuario = new Usuario(1, nome, mapaQtdFig);
            ListaDeUsuario.getUsuarios().add(usuario);
            response.sendRedirect("usuario-listar.html");
        } else {

        }
    }

    private void criarFormUsuario(HttpServletRequest request, HttpServletResponse response) {

    }

    private void listarUsuario(HttpServletResponse response, HttpServletRequest request) {

    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) {

    }

    private void excluiUsuario(HttpServletRequest request, HttpServletResponse response) {

    }

}
