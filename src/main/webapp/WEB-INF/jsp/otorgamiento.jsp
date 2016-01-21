<%-- 
    Document   : seleccionPrestamo
    Created on : 9/09/2014, 09:42:00 PM
    Author     : ucol
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><fmt:message key="title"/></title>

        <style type="text/css"> 
            <!--
            .style1 { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }
            -->
        </style>
        <link rel="stylesheet" type="text/css" href="resources/style.css"/>
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300'
	rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->

        <main class="page">
            <div class="container">
                <div class="vertical-buffer">
                    <div class="row">
                        <div class="col-md-8">
                            <!--jsp:include page="encabezado.jsp"/-->
                            <h2 class="buffer"><fmt:message key="tituloDatosPersonales"/></h2>
                            <hr class="red">

                            <fieldset>       

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="numeroIssste"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.numIssste}
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="rfc"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.rfc}
                                        </div>
                                    </div>
                                </div> 
                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="curp"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.curp}
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="nombre"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.nombre}
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="apellidoPaterno"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.apellidoPaterno}
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="apellidoMaterno"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.apellidoMaterno}
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="form-group vertical-buffer">
                                    <a href="caracteristicasPrestamo.htm" target="_blank" onClick="window.open(this.href, this.target, 'width=770,height=600');
                                            return false;" class="cierre">
                                        <fmt:message key="mensajeCaracteristicas"/></a>
                                </div>

                                <div class="alert alert-info">
                                    <b><fmt:message key="mensajeConfirmar"/></b>
                                </div>

                                <div class="pull-left text-muted hidden">
                                    * Campos obligatorios
                                </div>

                                <div class="row">
                                    <div class="col-md-8 col-md-offset-4">
                                        <hr>
                                    </div>
                                </div>

                                <c:if test="${banderaPrestamos == 1}">
                                    <form:form method="post" action="PrestamosAnterioresDescargar.pdf" id="planFinanciamientoForm" commandName="command" >

                                        <input type="hidden" id="num_issste" name="num_issste" value="${directoVO.numIssste}"/>

                                        <!--div class="form-group vertical-buffer">
                                            <a href="javascript:;" onclick="document.getElementById('planFinanciamientoForm').submit();">
                                                <IMG SRC="img/descargar.PNG" border="0"/> </a>
                                        </div-->
                                        <table class="table table-striped  vertical-buffer">
                                            <tr>
                                                <th colspan="2">
                                            <h4><fmt:message key="etiqDatosPrestamo"/></h4>
                                            </th>
                                            </tr>
                                            <tr>
                                                <th><fmt:message key="etiqFechaPrestamo"/></th><td>${prstamoOrigVO.auxFechaPrestamo}</td>
                                            </tr>
                                            <tr>
                                                <th><fmt:message key="etiqNumeroFolio"/></th><td>${prstamoOrigVO.nbrFolio}</td>
                                            </tr>
                                        </table>

                                        <div class="form-group">
                                            <a class="btn btn-default" href="javascript:;" onclick="document.getElementById('planFinanciamientoForm').submit();">
                                                <span class="glyphicon glyphicon-floppy-disk"></span> Descargar
                                            </a>
                                        </div>
                                    </form:form>
                                </c:if>

                                <form:form method="post" action="confirmacionFolio.htm" commandName="command" >
                                    <input type="hidden" id="rfc" name="rfc" value="${directoVO.rfc}"/>
                                    <input type="hidden" id="curp" name="curp" value="${directoVO.curp}"/>
                                    <input type="hidden" id="issste" name="issste" value="${directoVO.numIssste}"/>
                                    <input type="hidden" id="nombre" name="nombre" value="${directoVO.nombre}"/>
                                    <input type="hidden" id="apellidoPaterno" name="apellidoPaterno" value="${directoVO.apellidoPaterno}"/>
                                    <input type="hidden" id="apellidoMaterno" name="apellidoMaterno" value="${directoVO.apellidoMaterno}"/>
                                    <input type="hidden" id="banderaPrestamos" name="banderaPrestamos" value="${banderaPrestamos}"/>

                                    <div class="pull-right">
                                        <button type="submit" name="Regresar" onclick="history.back()" id="btnRegresa" class="btn btn btn-default ">Anterior</button>
                                        <input  type="submit" name="botonAceptarDatos" value="Confirmar" class="btn btn btn-primary "/>
                                    </div>
                                    <!--button type="submit" name="botonAceptarDatos" id="btnAceptar" class="btn btn btn-primary " >Confirmar</button-->
                                </form:form>
                            </fieldset>


                        </div>
                    </div>
                </div>
        </main>
    </body>
</html>
