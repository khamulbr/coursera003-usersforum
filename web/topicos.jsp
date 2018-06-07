<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fórum - Lista de Tópicos</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/mui.css" />
        <script src="js/mui.js"></script>
    </head>
    <body>
        <hgroup>
        <h1>Fórum de Usuários - Lista de Tópicos</h1>
        <h3>${usuario.nome}, leia e acesse os tópicos abaixo:</h3>
        </hgroup>
        <div class="mui-container">
            <table class="mui-table mui-table--bordered">
                <thead>
                  <tr>
                    <th>Título</th>
                    <th>Usuário</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="topico" items="${topicos}">
                        <tr>
                            <td><a href="exibeTopico?id=${topico.id}">${topico.titulo}</a></td>
                            <td>${topico.login}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <footer>
            ${msgErro}
            <BR>
            Quer ver o ranking de usuários? Clique <a href="ranking">aqui</a> | Quer cadastrar um novo Tópico? Clique <a href="novoTopico.jsp">aqui</a>
        </footer>
    </body>
</html>
