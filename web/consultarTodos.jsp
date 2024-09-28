<%-- 
    Document   : consultarTodos
    Created on : 15 de nov. de 2023, 10:22:14
    Author     : Samara Justino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    </head>
    <body>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Idade</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Porte</th>
                    <th scope="col">Peso</th>
                    <th scope="col">Raça</th>
                    <th scope="col">Cor</th>
                    <th scope="col">Deficiência</th>
                    <th scope="col">Observação</th>

                </tr>
                <c:forEach var="animal" items="${animaisConsultados}">
                    <tr>
                        <td scope="row">${animal.getId()}</td>
                        <td>${animal.getNome()}</td>
                        <td>${animal.getIdade()}</td>
                        <td>${animal.getTipo()}</td>
                        <td>${animal.getSexo()}</td>
                        <td>${animal.getPorte()}</td>
                        <td>${animal.getPeso()}</td>
                        <td>${animal.getRaca()}</td>
                        <td>${animal.getCor()}</td>
                        <td>${animal.getDeficiencia()}</td>
                        <td>${animal.getObservacao()}</td>

                    </tr>
                </c:forEach>  
        </table>
    </form>
</body>
</html>
