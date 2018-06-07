<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Fórum de Usuários</title>
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" media="screen" href="css/mui.css" />
        <script src="js/mui.js"></script>    
    </head>
    <body>
        <hgroup>
        <h1>Fórum de Usuários - Novo Tópico</h1>
        <h3>${usuario.nome}, para criar um novo Tópico, entre com as informações abaixo:</h3>
        </hgroup>
        <form method="post" action="novoTopico">
            <div class="group">
                <input type="text" name="titulo"><span class="highlight"></span><span class="bar"></span>
                <label>Título</label>
            </div>
            <div class="group">
                Conteúdo
                <textarea name="conteudo" cols="50" rows="5"></textarea>
            </div>
            <button type="submit" class="button buttonBlue">Criar Tópico
                <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
            </button>                
        </form>
        <footer>
            ${msgErro}
        </footer>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
    </body>
</html>
