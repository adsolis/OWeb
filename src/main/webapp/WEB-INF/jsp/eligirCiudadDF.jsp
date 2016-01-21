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
        <link href="resources/gobmx_estilos/assets/css/gobmx.css" rel="stylesheet">
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300'
              rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body>
        <main role="main">
            <div class="container">
                <div class="row">
                    <!--jsp:include page="encabezado.jsp"/-->
                    <h2 class="buffer"><fmt:message key="tituloEligirCiudad"/></h2>
                    <hr class="red">
                    <form:form id="elegirCiudadForm" method="post" action="elegirCiudadDF.htm" commandName="command">
                        <div class="col-md-8">
                            <input type="hidden" id="estadoEscoger" name="estadoEscoger"/>
                            <input type="hidden" id="issste" name="issste" value="${directoVO.numIssste}"/>
                            <input type="hidden" id="rfc" name="rfc" value="${directoVO.rfc}"/>
                            <input type="hidden" id="curp" name="curp" value="${directoVO.curp}"/>
                            <input type="hidden" id="nombre" name="nombre" value="${directoVO.nombre}"/>
                            <input type="hidden" id="apellidoPaterno" name="apellidoPaterno" value="${directoVO.apellidoPaterno}"/>
                            <input type="hidden" id="apellidoMaterno" name="apellidoMaterno" value="${directoVO.apellidoMaterno}"/>
                            <input type="hidden" id="folioSolicitud" name="folioSolicitud" value="${folioVO.folioSolicitud}"/>
                            <input type="hidden" id="numClave" name="numClave" value="${folioVO.clave}"/>
                            <input type="hidden" id="nomTcrCred" name="nomTcrCred" value="${tipoCredito.nomTcr}"/>
                            <input type="hidden" id="cveTcrCred" name="cveTcrCred" value="${tipoCredito.cveTcr}"/>
                            <input type="hidden" id="ramoDF" name="ramoDF" value="${ramoDF}"/>
                        </div>

                        <div id="tablaDFPresup">
                            <table width="100%">
                                <c:if test="${listaCajas.get(0).idEntidad != 9}">
                                    <tr>
                                        <td>

                                            <table  width="560" >

                                                <tr>
                                                    <td align="center" colspan="${listaCajas.size()}">
                                                        <font class="nombreEdo">
                                                        <a href="javascript:document.getElementById('estadoEscoger').value='EdoMex';document.getElementById('elegirCiudadForm').submit();" >
                                                            <fmt:message key="nombreEdoMex"/>
                                                        </a>
                                                        </font>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <c:forEach items="${listaCajas}" var="caja">
                                                        <td align="left">
                                                            <font class="nombreCiudades"> 
                                                            ${caja.ciudad}<br>
                                                            ${caja.calle}<br>
                                                            ${caja.colonia} ${caja.codigoPostal}
                                                            </font>
                                                        </td>
                                                    </c:forEach>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>

                                </c:if>
                                <c:if test="${listaCajas.get(0).idEntidad == 9}">
                                    <tr>
                                        <td width="200">
                                            <table  width="560">
                                                <tr>
                                                    <td align="center" colspan="${listaCajas.size()}">
                                                        <font class="nombreEdo">
                                                        <a href="javascript:document.getElementById('estadoEscoger').value='Distrito';document.getElementById('elegirCiudadForm').submit();">
                                                            <fmt:message key="nombreDistrito"/>
                                                        </a>
                                                        </font>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <c:forEach items="${listaCajas}" var="caja" varStatus="aux">

                                                        <c:if test="${(aux.count%3)==1}">
                                                        <tr></tr>
                                                    </c:if>
                                                    <td align="left">
                                                        <font class="nombreCiudades"> 
                                                        ${caja.ciudad}<br>
                                                        ${caja.calle}<br>
                                                        ${caja.colonia} ${caja.codigoPostal}
                                                        </font>
                                                    </td>

                                                </c:forEach>
                                    </tr>
                                </table>
                                </td>
                                </tr>
                            </c:if>
                            </table>

                        </div>
                        <div class="col-md-8">
                            <input type="submit"  name="regresarEligCiud" value="Anterior" onclick="history.back()" id="btnRegresa" class="btn btn btn-default "/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </main>
</body>
</html>
