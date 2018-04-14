<%-- 
    Document   : usuario-inserir
    Created on : 13/04/2018, 22:27:29
    Author     : Rian Alves
--%>

<%@page import="Modelos.ListaDeFigurinhas"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Figurinha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Criar Usuário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Usuário</h1>
        <div> Digite os dados correspondentes :  </div>
        <form method ="post">
            <label> Nome do Usuário:  <input name = "nome" required="true"/></label>

            <h1>Lista de Figurinhas:</h1>
            <table border = '1'>
                <thead>
                <th>Nome da Figurinha</th>
                <th>Quantidade Disponível</th>
                </thead>
                <tbody>
                    <% List<Figurinha> figurinha = ListaDeFigurinhas.getFigurinhas();
                        for (int i = 0; i < figurinha.size(); i++) {

                    %>
                    <tr>
                        <td><%=figurinha.get(i).getDescricao()%></td> 
                        <td><input required="true" type="number" name = <%=figurinha.get(i).getNumero()%> /></td>
                            <%
                                }
                            %>
                    </tr>
                </tbody>
            </table>
            <input type = "submit">
            <input type = "reset">


        </form>
    </body>
</html>
