<%-- 
    Document   : figurinha-listar
    Created on : 13/04/2018, 22:16:57
    Author     : Rian Alves
--%>

<%@page import="Modelos.Figurinha"%>
<%@page import="Modelos.ListaDeFigurinhas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Figurinhas</title>
    </head>
    <body>
        <h1>Lista de Figurinhas </h1>
        <table border = '1'>
            <tbody>
                <%for (int i=0; i<ListaDeFigurinhas.getFigurinhas().size();i++) {
                Figurinha figurinha = ListaDeFigurinhas.getFigurinhas().get(i);
                %>
                <tr>
                    <td><a href="figurinha-editar.html?linha=<%=i%>">Editar</a></td>
                    <td><a href="figurinha-excluir.html?linha=<%=i%>">Excluir</a></td>
                    <td><%=figurinha.getNumero()%></td>
                    <td><%=figurinha.getDescricao()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3"><a href="figurinha-inserir.html">Inserir Figurinha</a></td>
                </tr>
            </tfoot>
        </table>
    </ul>
</body>
</html>
