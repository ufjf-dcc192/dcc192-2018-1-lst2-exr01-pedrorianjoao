<%-- 
    Document   : usuario-possuidores
    Created on : 15/04/2018, 21:13:12
    Author     : jpdia
--%>

<%@page import="Modelos.ListaDeUsuario"%>
<%@page import="Modelos.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Figurinha"%>
<%@page import="Modelos.ListaDeFigurinhas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca por Donos de Figurinhas</title>
    </head>
    <body>
        <h1>Busca por Donos/Interessados de Figurinhas</h1>
        <form action="usuario-busca-figurinha.html">
            <select name="figurinhas">
                <%
                    List<Figurinha> figuras = ListaDeFigurinhas.getFigurinhas();
                    for (Figurinha figura : figuras) {
                %>
                <option value=<%= figura.getNumero()%> required="true"><%=figura.getDescricao()%></option>
                <%}%>
            </select>
            <select name="categoria">
                <option value="dono">Donos</option>
                <option value ="interessado">Interessados</option>
            </select>
            <input type = "submit">
            <input type = "reset">
        </form>
        <%if (((List<Usuario>) request.getAttribute("usuarios")) != null && ((Figurinha) request.getAttribute("figura")) != null) {%>
        <%if ("dono".equals(request.getAttribute("categoria"))) {%>
        <h1>Lista de Donos com a figurinha desejada </h1>
        <%}%>
        <%if ("interessado".equals(request.getAttribute("categoria"))) {%>
        <h1>Lista de Interessados na figurinha desejada </h1>
        <%}%>

        <table border = '1'>
            <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Figurinha</th>
            <th>Quantidade</th>
        </thead>
        <tbody>
            <%
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                Figurinha figura = (Figurinha) request.getAttribute("figura");
                if (usuarios.size() > 0) {
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario usuario = usuarios.get(i);
            %>
            <tr>
                <td><%=usuario.getIdUsuario()%></td>
                <td><%=usuario.getNomeUsuario()%></td>
                <td><%=figura.getDescricao()%></td>
                <td><%=ListaDeUsuario.getQuantidadePorUsuario(usuario, figura)%></td>
            </tr>
            <%
                }
            } else {%>
            <tr>
                <td colspan="4"><h2>Não foram encontrados usuários</h2></td>
            </tr>
            <%}
                }
            %>
        </tbody>
    </table>
</body>
</html>
