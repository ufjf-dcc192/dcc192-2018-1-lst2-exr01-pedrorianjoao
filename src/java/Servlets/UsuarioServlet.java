package Servlets;

import Modelos.FigurasDoAlbum;
import Modelos.Figurinha;
import Modelos.ListaDeFigurinhas;
import Modelos.ListaDeUsuario;
import Modelos.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario-listar.html", "/usuario-inserir.html", "/usuario-editar.html", "/usuario-excluir.html", "/usuario-possuidores.html", "/usuario-busca-figurinha.html"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (null != request.getServletPath()) {
            switch (request.getServletPath()) {
                case "/usuario-listar.html":
                    listarUsuario(response, request);
                    break;
                case "/usuario-inserir.html":
                    criarFormUsuario(request, response);
                    break;
                case "/usuario-editar.html":
                    editarUsuario(request, response);
                    break;
                case "/usuario-excluir.html":
                    excluiUsuario(request, response);
                    break;
                case "/usuario-visualizar.html":
                    excluiUsuario(request, response);
                    break;
                case "/usuario-possuidores.html":
                    criarbuscarUsuarios(request, response);
                    break;
                case "/usuario-busca-figurinha.html":
                    buscaUsuariosFigurinha(request, response);
                    break;
                default:
                    response.sendError(404);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("operacao") == null) {
            response.setContentType("text/html;charset=UTF-8");
            String nome = request.getParameter("nome");
            ArrayList<FigurasDoAlbum> mapaQtdFig = new ArrayList<>();

            ArrayList<Figurinha> figurinhas = (ArrayList<Figurinha>) ListaDeFigurinhas.getFigurinhas();
            for (int i = 0; i < figurinhas.size(); i++) {
                FigurasDoAlbum figuras;
                if (request.getParameter(Integer.toString(figurinhas.get(i).getNumero())) != null) {
                    figuras = new FigurasDoAlbum(figurinhas.get(i), Integer.parseInt(request.getParameter(Integer.toString(figurinhas.get(i).getNumero()))));
                    mapaQtdFig.add(figuras);
                } else {
                    figuras = new FigurasDoAlbum(figurinhas.get(i), 0);
                    mapaQtdFig.add(figuras);
                }
            }
            Usuario usuario = new Usuario(nome, mapaQtdFig);
            ListaDeUsuario.getUsuarios().add(usuario);
            response.sendRedirect("usuario-listar.html");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            int codigo = Integer.parseInt(request.getParameter("operacao"));
            String nome = request.getParameter("nome");
            ArrayList<FigurasDoAlbum> mapaQtdFig = new ArrayList<>();
            ArrayList<Figurinha> figurinhas = (ArrayList<Figurinha>) ListaDeFigurinhas.getFigurinhas();
            for (int i = 0; i < figurinhas.size(); i++) {
                FigurasDoAlbum figuras;
                if (request.getParameter(Integer.toString(figurinhas.get(i).getNumero())) != null) {
                    figuras = new FigurasDoAlbum(figurinhas.get(i), Integer.parseInt(request.getParameter(Integer.toString(figurinhas.get(i).getNumero()))));
                    mapaQtdFig.add(figuras);
                } else {
                    figuras = new FigurasDoAlbum(figurinhas.get(i), 0);
                    mapaQtdFig.add(figuras);
                }
            }
            ListaDeUsuario.getUsuarios().get(codigo).setNomeUsuario(nome);
            ListaDeUsuario.getUsuarios().get(codigo).setMapaQtdFig(mapaQtdFig);
            response.sendRedirect("usuario-listar.html");
        }
    }

    private void criarFormUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/usuario-inserir.jsp");
        despachante.forward(request, response);
    }

    private void listarUsuario(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        List<Usuario> usuarios = ListaDeUsuario.getUsuarios();
        request.setAttribute("usuarios", usuarios);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/usuario-listar.jsp");
        despachante.forward(request, response);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("linha"));
        List<Usuario> usuarios = ListaDeUsuario.getUsuarios();
        Usuario usuario = usuarios.get(codigo);
        request.setAttribute("usuario", usuario);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/usuario-editar.jsp");
        despachante.forward(request, response);
    }

    private void excluiUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("linha"));
        List<Usuario> usuarios = ListaDeUsuario.getUsuarios();
        usuarios.remove(codigo);
        response.sendRedirect("usuario-listar.html");
    }

    private void criarbuscarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/usuario-possuidores.jsp");
        despachante.forward(request, response);
    }

    private void buscaUsuariosFigurinha(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        int codigo = Integer.parseInt(request.getParameter("figurinhas"));
        String categoria = request.getParameter("categoria");
        Figurinha figura = ListaDeFigurinhas.getFigurinhas().get(codigo);
        List<Usuario> usuarios;
        if ("interessado".equals(categoria)) {
            usuarios = ListaDeUsuario.getInteressados(figura);
        } else {
            usuarios = ListaDeUsuario.getDonos(figura);
        }
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("figura", figura);
        request.setAttribute("categoria", categoria);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/usuario-possuidores.jsp");
        despachante.forward(request, response);
    }

}
