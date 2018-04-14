
<%@page import="Modelos.FigurasDoAlbum"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="Modelos.ListaDeFigurinhas"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Figurinha"%>
<%@page import="Modelos.Usuario"%>
<%@page import="Modelos.ListaDeUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar tarefa</title>
    </head>
    <body>
        <% Usuario usuario = (Usuario) request.getAttribute("usuario");
            int codigo = ListaDeUsuario.getUsuarios().indexOf(usuario);
        %> 
        <h1> Edição da usuário </h1>
        <form method="post">
            <label> Nome do Usuário:  <input name = "nome" required="true" value = <%=usuario.getNomeUsuario()%>/></label>

            <h1>Lista de Figurinhas:</h1>
            <table border = '1'>
                <thead>
                <th>Nome da Figurinha</th>
                <th>Quantidade Disponível</th>
                </thead>
                <tbody>
                    <%
                        for (FigurasDoAlbum figuras : usuario.getMapaQtdFig()) {
                    %>
                    <tr>
                        <td><%=figuras.getFigura().getDescricao()%></td> 
                        <td><input name = <%=figuras.getFigura().getNumero()%> value=<%=figuras.getQuantidade()%> /></td>

                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <input type="submit"/>
            <input type="reset"/>
            <input type="" value="<%=codigo%>" name="operacao"/>
        </form>
    </body>
</html>
