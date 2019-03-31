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
    <body>

        <section id="cover">
            <div id="cover-caption">
                <div class="row">                    
                    <div class="col-sm-5 offset-sm-3 text-center">
                        <h2 class="display-4">Listado de Pais!</h2>
                        <div class="info-form">
                            <form align="center" action="SvlPais.do" method="POST" class="form-inlin justify-content-center">
                                <input type="hidden" id="txtIdPais" name="txtIdPais" value="">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Siglas</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="txtSiglas" name="txtSiglas" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Capital</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="txtCapital" name="txtCapital" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Cant. Habitantes</label>
                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" id="txtCantHabitantes" name="txtCantHabitantes" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Ext. Territorio</label>
                                    <div class="col-sm-10">
                                        <input type="number" class="form-control" id="txtExtenTerritorio" step="0.00001" name="txtExtenTerritorio" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Idioma</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="txtIdioma" name="txtIdioma" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Moneda</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="txtMoneda" name="txtMoneda" value=""><br>
                                    </div>
                                </div>
                                <input type="submit" class="btn btn-success" name="guardar" value="Guardar">
                                <input type="reset" class="btn btn-info" value="Limpiar">
                            </form>
                            <br>
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
                        <table class="table table-sm table-responsive">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Siglas</th>
                                    <th scope="col">Capital</th>
                                    <th scope="col">Cant. Habitantes</th>
                                    <th scope="col">Ext. Territorio</th>
                                    <th scope="col">Idioma</th>
                                    <th scope="col">Moneda</th>
                                    <th scope="col">Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Pais pa = new Pais();
                                    for (Pais p : pa.ListarPais()) {
                                %>

                                <tr>
                                    <td><%out.print(p.getIdPais());%></td>
                                    <td><%out.print(p.getSiglas());%></td>
                                    <td><%out.print(p.getCapital());%></td>
                                    <td><%out.print(p.getCantHabitantes());%></td>
                                    <td><%out.print(p.getExtenTerritorio());%></td>
                                    <td><%out.print(p.getIdioma());%></td>
                                    <td><%out.print(p.getMoneda());%></td>
                                    <td>
                                        <input type="button" onclick="javascript:edit(<%out.print(p.getIdPais());%>, '<%out.print(p.getSiglas());%>',
                                                        '<%out.print(p.getCapital());%>',<%out.print(p.getCantHabitantes());%>,<%out.print(p.getExtenTerritorio());%>,
                                                        '<%out.print(p.getIdioma());%>', '<%out.print(p.getMoneda());%>')" class="btn btn-warning btn-sm" value="Update"/>
                                        <form action="SvlPais.do" method="POST">
                                            <input type="hidden" name="idDelete"  value="<%out.print(p.getIdPais());%>">
                                            <input type="submit" class="btn btn-danger btn-sm" value="Delete" name="Eliminar">
                                        </form>                
                                    </td>    
                                </tr>

                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
