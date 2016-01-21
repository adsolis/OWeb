<%-- 
    Document   : seleccionPrestamo
    Created on : 10/09/2014, 09:42:00 PM
    Author     : ucol
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><fmt:message key="title"/></title>
        <link rel="stylesheet" type="text/css" href="resources/style.css"/>
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300'
              rel='stylesheet' type='text/css'>
    </head>

    <body>
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->
        <main role="main">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <!--jsp:include page="encabezado.jsp"/-->
                        <div class="vertical-buffer">
                            <h2><fmt:message key="tituloVentanillaCajas"/></h2>
                            <hr class="red">
                        </div>
                        <form:form id="mapasForm" method="post" action="mapaCajasPagadoras.htm" commandName="command">   
                            <c:if test="${nombreImagen!=0}">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <img src="img/${nombreImagen}.PNG"/>
                                    </div>
                                </div>
                            </c:if>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <input type="hidden" id="ciudadDF" name="ciudadDF" value="${ciudadDF}"/>
                                    <input type="hidden" id="numClave" name="numClave" value="${folioVO.clave}"/>
                                    <input type="hidden" id="issste" name="issste" value="${directoVO.numIssste}"/>
                                    <input type="hidden" id="rfc" name="rfc" value="${directoVO.rfc}"/>
                                    <input type="hidden" id="curp" name="curp" value="${directoVO.curp}"/>
                                    <input type="hidden" id="nombre" name="nombre" value="${directoVO.nombre}"/>
                                    <input type="hidden" id="apellidoPaterno" name="apellidoPaterno" value="${directoVO.apellidoPaterno}"/>
                                    <input type="hidden" id="apellidoMaterno" name="apellidoMaterno" value="${directoVO.apellidoMaterno}"/>
                                    <input type="hidden" id="folioSolicitud" name="folioSolicitud" value="${folioVO.folioSolicitud}"/>
                                    <input type="hidden" id="nomTcrCred" name="nomTcrCred" value="${tipoCredito.nomTcr}"/>
                                    <input type="hidden" id="cveTcrCred" name="cveTcrCred" value="${tipoCredito.cveTcr}"/>
                                    <input type="hidden" id="sizeLista" name="sizeLista" value="${listaCajas.size()}"/>
                                    <input type="hidden" id="nombreImagen" name="nombreImagen" value="${nombreImagen}"/>
                                    <input type="hidden" id="idCajaEntidad" name="idCajaEntidad"/>
                                    <input type="hidden" id="idCajaDelegacion" name="idCajaDelegacion"/>
                                    <input type="hidden" id="idCajaUnidad" name="idCajaUnidad"/>
                                    <input type="hidden" id="idCajaOficina" name="idCajaOficina"/>
                                    <input type="hidden" id="ramoDF" name="ramoDF" value="${ramoDF}"/>

                                    <c:forEach items="${listaCajas}" var="caja">
                                        <br>
                                        <a  href="javascript:document.getElementById('idCajaEntidad').value='${caja.idEntidad}';document.getElementById('idCajaDelegacion').value='${caja.idDelegacion}';
                                            document.getElementById('idCajaUnidad').value='${caja.idUniad}';document.getElementById('idCajaOficina').value='${caja.idOficina}';
                                            document.getElementById('mapasForm').submit();" >
                                            ${caja.ciudad}</a>
                                        </c:forEach>
                                </div>
                            </div>
                        </form:form>
                        <div class="col-md-8 col-md-offset-4">
                            <hr>
                        </div>
                        <div class="pull-right">
                            <input type="submit"  name="regresarMapa" value="Anterior" class="btn btn-default pull-right"/>   
                        </div>
                    </div>
                </div>
        </main>
    </body>
</html>
