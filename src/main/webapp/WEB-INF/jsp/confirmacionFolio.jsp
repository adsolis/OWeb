<%-- 
    Document   : seleccionPrestamo
    Created on : 10/09/2014, 09:42:00 PM
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
        <script language="javascript" type="text/javascript" src="js/general.js"></script>
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
                        <div class="vertical-buffer">
                            <div id="alertaFolioDiv" class="form-group"></div>
                            <!--jsp:include page="encabezado.jsp"/-->
                            <form:form method="post" name="formD" id="formD" action="confirmacionFolio.htm" commandName="command" >
                                <c:if test="${tipoVentana == 1}">
                                    <h2><fmt:message key="confirmarFolioC"/></h2>
                                </c:if>
                                <c:if test="${tipoVentana == 2 || tipoVentana == 3}">
                                    <h2><fmt:message key="confirmarSolicitud"/></h2>
                                </c:if>
                                <hr class="red">
                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="numeroIssste"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.numIssste}
                                            <input type="hidden" id="issste" name="issste" value="${directoVO.numIssste}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="rfc"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.rfc}
                                            <input type="hidden" id="rfc" name="rfc" value="${directoVO.rfc}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="curp"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.curp}
                                            <input type="hidden" id="curp" name="curp" value="${directoVO.curp}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="nombre"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.nombre}
                                            <input type="hidden" id="nombre" name="nombre" value="${directoVO.nombre}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="apellidoPaterno"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.apellidoPaterno}
                                            <input type="hidden" id="apellidoPaterno" name="apellidoPaterno" value="${directoVO.apellidoPaterno}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="apellidoMaterno"/></label>
                                        <div class="col-sm-8">
                                            ${directoVO.apellidoMaterno}
                                            <input type="hidden" id="apellidoMaterno" name="apellidoMaterno" value="${directoVO.apellidoMaterno}"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="pull-left text-muted hidden">
                                    * Campos obligatorios
                                </div>

                                <c:if test="${tipoVentana == 1}">
                                    <div class="form-group">
                                        <div class="row">
                                            <label class="col-sm-4 control-label"><fmt:message key="etiqDigitarFolio"/></label>
                                            <div class="col-sm-6">
                                                <form:input class="form-control" name="folio1" id="folio1" path="folioSolicitud" placeholder="Digita el número de folio de tu solicitud" required="" maxlength="9" size="41" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <label class="col-sm-4 control-label"><fmt:message key="etiqConfirmFolio"/></label>
                                            <div class="col-sm-6">
                                                <form:input class="form-control" name="folio2" id="folio2" path="conFolioSolici"  placeholder="Confirmar folio" required="" maxlength="9" size="41"/>
                                            </div>
                                        </div>
                                    </div>

                                    <form:form method="post"  action="confirmacionFolio.htm" commandName="command" >

                                        <div class="pull-right">
                                            <input type="hidden" id="banderaPrestamos" name="banderaPrestamos" value="${banderaPrestamos}"/>
                                            <input type="hidden" id="numClave" name="numClave" value="${activaClave}"/>
                                            <button type="submit" name="Regresar" onclick="history.back()" id="btnRegresa" class="btn btn btn-default ">Anterior</button>
                                            <input type="submit" name="botonAceptarC" value="Continuar" onclick="return valida(formD)" class="btn btn btn-primary "/>
                                        </div>
                                    </form:form>
                                </c:if>


                                <c:if test="${tipoVentana == 2 || tipoVentana == 3}">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="etiqFolio"/></label>
                                        <div class="col-sm-8">
                                            ${folioVO.folioSolicitud}
                                        </div>
                                    </div>
                                </c:if>

                                <c:if test="${tipoVentana == 2 || tipoVentana == 3}">
                                    <div class="row">
                                        <label class="col-sm-4 control-label"><fmt:message key="etiqTipoCredito"/></label>
                                        <div class="col-sm-8">
                                            ${tipoCredito.nomTcr}
                                        </div>
                                    </div>
                                </c:if>



                                <c:if test="${tipoCredito.cveTcr==21}">
                                    <div class="row">
                                        <form:radiobutton path="vehiculo" value="A" checked="checked"/>Automóvil
                                        <div class="col-sm-8">
                                            <form:radiobutton path="vehiculo" value="M" />Motocicletas
                                        </div>
                                    </div>      
                                </c:if>

                                <c:if test="${activaClave}">
                                    <div class="col-sm-8">
                                        <form:label path="clave"><fmt:message key="etiqClaveFolio"/></form:label>
                                        </div>
                                        <div class="col-sm-8">
                                        <form:input type="PASSWORD" name="claveFol" id="claveFol" path="clave" maxlength="8" />
                                    </div>
                                </c:if>

                                <c:if test="${tipoVentana == 2 || tipoVentana == 3}">
                                    <div class="alert alert-info">
                                        <b><fmt:message key="mensajeCalculosOtorgamiento"/></b>
                                    </div>
                                </c:if>

                                <c:if test="${tipoVentana == 2}">
                                    <form:form method="post" action="confirmacionFolio.htm" commandName="command" >

                                        <input type="hidden" id="ciudadDF" name="ciudadDF" value="${ciudadDF}" />
                                        <input type="hidden" id="nomTcrCred" name="nomTcrCred" value="${tipoCredito.nomTcr}" />
                                        <input type="hidden" id="cveTcrCred" name="cveTcrCred" value="${tipoCredito.cveTcr}"/>
                                        <input type="hidden" id="imagen" name="imagen" value="${imagen}"/>
                                        <input type="hidden" id="numClave" name="numClave" value="${folioVO.clave}"/>
                                        <input type="hidden" id="ramoDF" name="ramoDF" value="${ramoDF}"/>


                                        <input type="hidden" id="idCajaEntidad" name="idCajaEntidad" value="${cajaPagar.idEntidad}"/>
                                        <input type="hidden" id="idCajaDelegacion" name="idCajaDelegacion" value="${cajaPagar.idDelegacion}"/>
                                        <input type="hidden" id="idCajaUnidad" name="idCajaUnidad"  value="${cajaPagar.idUniad}"/>
                                        <input type="hidden" id="idCajaOficina" name="idCajaOficina"  value="${cajaPagar.idOficina}"/>
                                        <input type="hidden" id="idCajaCiudad" name="idCajaCiudad"  value="${cajaPagar.ciudad}"/>
                                        <input type="hidden" id="cveTcrCred" name="cveTcrCred" value="${tipoCredito.cveTcr}"/>
                                        <input type="hidden" id="nomTcrCred" name="nomTcrCred" value="${tipoCredito.nomTcr}" />
                                        <input type="hidden" id="folioSolicitud" name="folioSolicitud" value="${folioVO.folioSolicitud}"/>

                                        <div class="pull-right">    
                                            <input type="submit" name="regresarDos"  value="Anterior" class="btn btn btn-default pull-right"/>
                                            <input type="submit"  name="botonCalculos" value="Confirmar" class="btn btn btn-primary "/>
                                        </div>

                                    </form:form>   
                                </c:if>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </main>    
    </body>
</html>
