<%-- 
    Document   : index
    Created on : Mar 26, 2019, 1:47:21 PM
    Author     : angel
--%>

<%@page import="Model.Pais"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Paises</title>
        <script src="js/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert.css">
        <link rel="stylesheet" type="text/css" href="js/facebook.css">
        <script src="js/actions.js" type="text/javascript"></script>
        <script src="sweet_integrantes.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="EventoAlert()">


        <section id="cover">
            <div id="cover-caption">
                <div class="row">                    
                    <div class="col-sm-5 offset-sm-3 text-center">
                        <h2 class="display-4">CREA TABLA!</h2>
                        <div class="info-form">
                            <form align="center" action="SvlDB.do" method="POST" class="form-inlin justify-content-center"  >
                        </div>

                        <input type="submit" id="crear" class="btn btn-success" name="tabla" value="CREA TABLA">
                        </form>
                        <input type="submit" class="btn btn-success" value="INTEGRANTES" onclick="Sweet_integrantes()">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="cover">
        <div id="cover-caption">
            <div class="row">                    
                <div class="col-sm-12 offset-sm-3 text-center">

                </div>
            </div>
        </div>
    </section>
</body>
</html>
<script>

    function EventoAlert() {
        swal("Ejercicio Paises", "Base de datos creada exitosamente! \n Favor, pincha el boton para crear la Tabla!", "success");
    }






</script>