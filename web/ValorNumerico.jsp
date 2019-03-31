<%-- 
    Document   : ValorNumerico
    Created on : 29-ene-2019, 19:33:04
    Author     : Lab3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="js/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert.css">
        <link rel="stylesheet" type="text/css" href="js/facebook.css">
        <script src="js/actions.js" type="text/javascript"></script>
        <script src="sweet_integrantes.js" type="text/javascript"></script>
        <script language="javascript" type="text/javascript">
            function enviar(pagina) {
                document.nombreDelFormulario.action = pagina;
                document.nombreDelFormulario.submit();
            }
        </script>
    </head>
    <body>
        <h1>Existen campos que deben ser numericos</h1>
        <form name="nombreDelFormulario" action="" method="post">
            <input type="button" value="ir a pagina 1" onClick="enviar('index.jsp')">
            <!input type="button" value="ir a pagina 2" onClick="enviar('pagina2.html')"-->
        </form>
         <input type="submit" class="btn btn-success" value="INTEGRANTES" onclick="Sweet_integrantes()">
    </body>
</html>
