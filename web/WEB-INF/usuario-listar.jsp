<%@page import="Modelos.Usuario"%>
<%@page import="Modelos.Figurinha"%>
<%@page import="Modelos.ListaDeFigurinhas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
    </head>
    <body>
        <h1>Lista de Usuários </h1>
        <table border = '1'>
            <tbody>
                <%for (int i=0; i<ListaDeUsuarios.getUsuarios().size();i++) {
                Usuario usuario = ListaDeUsuarios.getUsuarios().get(i);
                %>
                <tr>
                    <td><a href="usuario-editar.html?linha=<%=i%>">Editar</a></td>
                    <td><a href="usario-excluir.html?linha=<%=i%>">Excluir</a></td>
                    <td><%=usuario.getIdUsuario()%></td>
                    <td><%=usuario.getNomeUsuario()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3"><a href="nova.html">Nova Tarefa</a></td>
                </tr>
            </tfoot>
        </table>
    </ul>
</body>
</html>
