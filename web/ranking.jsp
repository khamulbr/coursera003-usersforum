<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fórum - Ranking de Usuários</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/mui.css" />
        <script src="js/mui.js"></script>
    </head>
    <body>
        <hgroup>
        <h1>Fórum de Usuários - Ranking de Usuários</h1>
        </hgroup>
        <div class="mui-container">
            <table class="mui-table mui-table--bordered">
                <thead>
                  <tr>
                    <th>Usuário</th>
                    <th>Pontuação</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${ranking}">
                        <tr>
                            <td>${usuario.login}</td>
                            <td>${usuario.pontos}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <footer>
            ${msgErro}
            <BR>
            Clique <a href="topicos">aqui</a> para retornar para a lista de Tópicos
        </footer>
    </body>
</html>
