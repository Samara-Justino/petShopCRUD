<%-- 
    Document   : consultarId
    Created on : 15 de nov. de 2023, 12:48:22
    Author     : Samara Justino
--%>

<%@page import="model.Animal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <tr>

                <td><%Animal animal = (Animal) request.getAttribute("animal");
                        out.println(animal.getNome()); %></td>
                <td><% out.println(animal.getIdade());%></td>
                <td><%out.println(animal.getTipo());%></td>
                <td><%  out.println(animal.getSexo());%></td>
                <td><%  out.println(animal.getPorte());%></td>
                <td><% out.println(animal.getPeso());%></td>
                <td><%    out.println(animal.getRaca());%></td>
                <td><%out.println(animal.getCor());%></td>
                <td><% out.println(animal.getDeficiencia());%></td>
                <td><% out.println(animal.getObservacao());%></td>


            </tr>
    </body>
</html>
