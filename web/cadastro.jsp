<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Fórum de Usuários</title>
        <link href="css/style.css" rel="stylesheet">
        
    </head>
    <body>
        <hgroup>
        <h1>Fórum de Usuários - cadastro</h1>
        <h3>Para realizar seu cadastro, entre com as informações abaixo:</h3>
        </hgroup>
        <form method="post" action="cadastro">
            <div class="group">
                <input type="text" name="nome"><span class="highlight"></span><span class="bar"></span>
                <label>Nome</label>
            </div>
            <div class="group">
                <input type="text" name="login"><span class="highlight"></span><span class="bar"></span>
                <label>Login</label>
            </div>
            <div class="group">
                <input type="email" name="email"><span class="highlight"></span><span class="bar"></span>
                <label>E-mail</label>
            </div>
            <div class="group">
             <input type="password" name="senha"><span class="highlight"></span><span class="bar"></span>
                <label>Senha</label>
            </div>
            <button type="submit" class="button buttonBlue">Realizar cadastro
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
