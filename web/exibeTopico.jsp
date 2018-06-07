<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fórum de Usuários</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/mui.css" />
        <script src="js/mui.js"></script>    
    </head>
    <body>
        <hgroup>
        <h1>Fórum de Usuários - Exibir Tópico</h1>
        <h3>Veja o Tópico selecionado abaixo:</h3>
        </hgroup>
        <div class="mui-container">
            <div class="group">
                <input type="text" name="titulo" disabled="true">${topico.titulo}<span class="highlight"></span><span class="bar"></span>
                <label>Título</label>
            </div>
            <div class="group">
                Conteúdo
                <textarea name="conteudo" cols="50" rows="5" disabled>${topico.conteudo}</textarea>
            </div>
            <div class="group">
                <input type="text" name="login" disabled="true">${topico.login}<span class="highlight"></span><span class="bar"></span>
                <label>Login</label>
            </div>
        </div>
        <hgroup>
            <h3>Veja os Comentários do Tópico selecionado abaixo:</h3>
        </hgroup>    
        <div class="mui-container">
            <table class="mui-table mui-table--bordered">
                <thead>
                  <tr>
                    <th>Comentário</th>
                    <th>Usuário</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="coment" items="${comentarios}">
                        <tr>
                            <td>${coment.comentario}</td>
                            <td>${coment.login}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> 
        <hgroup>
            <h3>Para comentar, preencha os campos abaixo:</h3>
        </hgroup>           
        <form method="post" action="novoComentario">
            <div class="group">
                <input type="text" name="comentario"><span class="highlight"></span><span class="bar"></span>
                <label>Comentário</label>
            </div>
            <button type="submit" class="button buttonBlue">Criar Comentário
                <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
            </button>  
            <input type="hidden" name="id_topico" value="${topico.id}">
        </form>                
                
        <footer>
            ${msgErro}
            <BR>
            Clique <a href="topicos">aqui</a> para retornar para a lista de Tópicos
        </footer>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
    </body>
</html>
