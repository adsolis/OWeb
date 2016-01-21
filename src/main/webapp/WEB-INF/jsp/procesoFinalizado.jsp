<%-- 
    Document   : seleccionPrestamo
    Created on : 10/09/2014, 09:42:00 PM
    Author     : UCOL
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
        <link href="resources/gobmx_estilos/assets/css/gobmx.css" rel="stylesheet">
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300'
              rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body>
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->
        <main role="main">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <!--jsp:include page="encabezado.jsp"/-->
                        <div class="vertical-buffer">
                            <h2><fmt:message key="confirmarSolicitud"/></h2>
                            <hr class="red">
                        </div>
                        <form:form  id="formProc" method="post" action="confirmarCredito.htm" commandName="command">
                                <h4><fmt:message key="tituloDatosPersonales"/></h4>
                            <fmt:setLocale value="es_MX" variant="" />
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
                            <table class="table table-striped" width="100%">
                                <tbody>
                                    <tr>
                                        <th colspan="2"><h4><fmt:message key="caracteristicasTitulo"/></h4></th>
                                </tr>
                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqImporPrest"/> </th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber value="${presolicitudVO.prstamoOrigVO.origLoanPrin}" pattern="###,###,###,##0.00" groupingUsed="TRUE" />						</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqPrimaGaran"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.prstamoOrigVO.warrantyPrem}" />						</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqSaldoPrestAnt"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.saldoRef}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqPrimaRenov"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.prstamoOrigVO.renewalPrem}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqImporCheq"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.prstamoOrigVO.impLiquido}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqDescuento"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.prstamoOrigVO.payAmt}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqPeriodici"/></th>
                                    <td class="col-sm-8">${presolicitudVO.periodicidad}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqNumPagos"/></th>
                                    <td class="col-sm-8">${presolicitudVO.prstamoOrigVO.origNbrPay}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqDescuenIni"/></th>
                                    <td class="col-sm-8"> ${iniciaDescuento}
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqDescuenFin"/></th>
                                    <td class="col-sm-8">${finDescuento}
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqTasaInterA"/></th>
                                    <td class="col-sm-8"><fmt:formatNumber pattern="##0.00" value="${presolicitudVO.prstamoOrigVO.intRate}" /><fmt:message key="etiqPorcentajeTase"/></td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqSuelBasiMe"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.sueldoMensual}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqAntiguedad"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cAntiguedadVO.anio} <fmt:message key="etiqAnios"/> ${presolicitudVO.cAntiguedadVO.mes} <fmt:message key="etiqMes"/> ${presolicitudVO.cAntiguedadVO.dia} <fmt:message key="etiqDias"/></td>
                                </tr>

                                <tr>
                                    <th align="left" colspan="2"><h4>
                                    <fmt:message key="mensajeDeducciones"/>
                                </h4><h4></h4></th>
                                </tr>

                                <tr><th class="col-sm-4"><fmt:message key="etiqDesCredFov"/></th>
                                    <td class="col-sm-8"><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber pattern="###,###,###,##0.00" value="${presolicitudVO.deduccionesVO}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqCodPostal"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cajaPagadoraVO.codigoPostal}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etidEstado"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cajaPagadoraVO.entidad}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqCiudad"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cajaPagadoraVO.ciudad}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqColonia"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cajaPagadoraVO.colonia}</td>
                                </tr>

                                <tr>
                                    <th class="col-sm-4"><fmt:message key="etiqCalle"/></th>
                                    <td class="col-sm-8">${presolicitudVO.cajaPagadoraVO.calle}</td>
                                </tr>
                                </tbody>
                            </table>

                            <div class="alert alert-info"><fmt:message key="mensajeDeOtorgamiento"/></div>


                            <table class="table table-striped" width="100%">
                                <tbody><tr>
                                        <td align="left" colspan="2"><fmt:message key="mensajeDeAceptarCalculos"/><br>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <div class="col-sm-8">
                                <input type="hidden" id="numIssste" name="numIssste" value="${presolicitudVO.directo.numIssste}"/>
                                <input type="hidden" id="rfc" name="rfc" value="${presolicitudVO.directo.rfc}"/>
                                <input type="hidden" id="curp" name="curp" value="${presolicitudVO.directo.curp}"/>
                                <input type="hidden" id="nombre" name="nombre" value="${presolicitudVO.directo.nombre}"/>
                                <input type="hidden" id="apellidoPaterno" name="apellidoPaterno" value="${presolicitudVO.directo.apellidoPaterno}"/>
                                <input type="hidden" id="apellidoMaterno" name="apellidoMaterno" value="${presolicitudVO.directo.apellidoMaterno}"/>
                                <input type="hidden" id="sexo" name="sexo" value="${presolicitudVO.directo.sexo}"/>
                                <input type="hidden" id="diaFec" name="diaFec" value="${presolicitudVO.diaFec}"/>
                                <input type="hidden" id="mesFec" name="mesFec" value="${presolicitudVO.mesFec}"/>
                                <input type="hidden" id="anioFec" name="anioFec" value="${presolicitudVO.anioFEc}"/>
                                <input type="hidden" id="folioSolicitud" name="folioSolicitud" value="${presolicitudVO.folioSol}"/>
                                <input type="hidden" id="tpoCredito" name="tpoCredito" value="${presolicitudVO.tpoCreditoVO.cveTcr}"/>
                                <input type="hidden" id="nomCredito" name="nomCredito" value="${presolicitudVO.tpoCreditoVO.nomTcr}"/>
                                <input type="hidden" id="vehiculo" name="vehiculo" value="${vehiculo}"/>
                                <!--input type="hidden" id="action" name="action" value="ventanaAuxiliar.htm"/-->

                                <!--Datos de la Presolicitud a guardar-->
                                <input type="hidden" id="vehiculo" name="vehiculo" value="${vehiculo}"/>
                                <input type="hidden" id="coberturaGlobVOEnt" name="coberturaGlobVOEnt" value="${presolicitudVO.coberturaGlobVO.entidad.cveEntidad}"/>
                                <input type="hidden" id="coberturaGlobVODel" name="coberturaGlobVODel" value="${presolicitudVO.coberturaGlobVO.delegacion.cveDeleg}"/>
                                <input type="hidden" id="coberturaGlobVOUni" name="coberturaGlobVOUni" value="${presolicitudVO.coberturaGlobVO.unidad.cveUniad}"/>
                                <input type="hidden" id="coberturaGlobVOOfi" name="coberturaGlobVOOfi" value="${presolicitudVO.coberturaGlobVO.oficina.cveOficina}"/>
                                <input type="hidden" id="descuentoProcVODif" name="descuentoProcVODif" value="${presolicitudVO.descuentoProcVO.dif}"/>
                                <input type="hidden" id="usuario" name="usuario" value="${presolicitudVO.usuario}"/>
                                <input type="hidden" id="componenteCVE" name="componenteCVE" value="${presolicitudVO.componenteCVE}"/>
                                <input type="hidden" id="numRamo" name="numRamo" value="${presolicitudVO.numRamo}"/>
                                <input type="hidden" id="numPagaduria" name="numPagaduria" value="${presolicitudVO.numPagaduria}"/>
                                <input type="hidden" id="cramPagVORamoCat" name="cramPagVORamoCat" value="${presolicitudVO.cramPagVO.ramoCat}"/>
                                <input type="hidden" id="cramPagVOPagaCat" name="cramPagVOPagaCat" value="${presolicitudVO.cramPagVO.pagaCat}"/>
                                <input type="hidden" id="cramPagVONombCat" name="cramPagVONombCat" value="${presolicitudVO.cramPagVO.nombCat}"/>
                                <input type="hidden" id="descRamo" name="descRamo" value="${presolicitudVO.descRamo}"/>
                                <input type="hidden" id="sueldoDer" name="sueldoDer" value="${presolicitudVO.sueldoDer}"/>
                                <input type="hidden" id="cveStatSol" name="cveStatSol" value="${presolicitudVO.cveStatSol}"/>
                                <input type="hidden" id="prstamoOrigVOIsssteNbr" name="prstamoOrigVOIsssteNbr" value="${presolicitudVO.prstamoOrigVO.isssteNbr}"/>
                                <input type="hidden" id="prstamoOrigVOAnioFolio" name="prstamoOrigVOAnioFolio" value="${presolicitudVO.prstamoOrigVO.anioFolio}"/>
                                <input type="hidden" id="prstamoOrigVOOrigLoanP" name="prstamoOrigVOOrigLoanP" value="${presolicitudVO.prstamoOrigVO.origLoanPrin}"/>
                                <input type="hidden" id="prstamoOrigVOImpLiquid" name="prstamoOrigVOImpLiquid" value="${presolicitudVO.prstamoOrigVO.impLiquido}"/>
                                <input type="hidden" id="prstamoOrigVOOrigLoanI" name="prstamoOrigVOOrigLoanI" value="${presolicitudVO.prstamoOrigVO.origLoanIntAmt}"/>
                                <input type="hidden" id="prstamoOrigVOOrigIva" name="prstamoOrigVOOrigIva" value="${presolicitudVO.prstamoOrigVO.origIva}"/>
                                <input type="hidden" id="prstamoOrigVODeferredI" name="prstamoOrigVODeferredI" value="${presolicitudVO.prstamoOrigVO.deferredInt}"/>
                                <input type="hidden" id="prstamoOrigVOWarrantyP" name="prstamoOrigVOWarrantyP" value="${presolicitudVO.prstamoOrigVO.warrantyPrem}"/>
                                <input type="hidden" id="prstamoOrigVORenewalPr" name="prstamoOrigVORenewalPr" value="${presolicitudVO.prstamoOrigVO.renewalPrem}"/>
                                <input type="hidden" id="prstamoOrigVOIntRate" name="prstamoOrigVOIntRate" value="${presolicitudVO.prstamoOrigVO.intRate}"/>
                                <input type="hidden" id="prstamoOrigVOivaRate" name="prstamoOrigVOivaRate" value="${presolicitudVO.prstamoOrigVO.ivaRate}"/>
                                <input type="hidden" id="prstamoOrigVOorigNbrPa" name="prstamoOrigVOorigNbrPa" value="${presolicitudVO.prstamoOrigVO.origNbrPay}"/>
                                <input type="hidden" id="prstamoOrigVOpayAmt" name="prstamoOrigVOpayAmt" value="${presolicitudVO.prstamoOrigVO.payAmt}"/>
                                <input type="hidden" id="prstamoOrigVOfirstPayP" name="prstamoOrigVOfirstPayP" value="${presolicitudVO.prstamoOrigVO.firstPayPerYrD}"/>
                                <input type="hidden" id="prstamoOrigVOlastPayPe" name="prstamoOrigVOlastPayPe" value="${presolicitudVO.prstamoOrigVO.lastPayPerYrDu}"/>
                                <input type="hidden" id="prstamoOrigVOnumPrest1" name="prstamoOrigVOnumPrest1" value="${presolicitudVO.prstamoOrigVO.numPrestRef1}"/>
                                <input type="hidden" id="prstamoOrigVOnumPrest2" name="prstamoOrigVOnumPrest2" value="${presolicitudVO.prstamoOrigVO.numPrestRef2}"/>
                                <input type="hidden" id="prstamoOrigVOnumPrest3" name="prstamoOrigVOnumPrest3" value="${presolicitudVO.prstamoOrigVO.numPrestRef3}"/>
                                <input type="hidden" id="prstamoOrigVOtipoPresu" name="prstamoOrigVOtipoPresu" value="${presolicitudVO.prstamoOrigVO.tipoPresup}"/>
                                <input type="hidden" id="prstamoOrigVOcveAfect" name="prstamoOrigVOcveAfect" value="${presolicitudVO.prstamoOrigVO.cveAfect}"/>
                                <input type="hidden" id="prstamoOrigVOtnoCve" name="prstamoOrigVOtnoCve" value="${presolicitudVO.prstamoOrigVO.tnoCve}"/>
                                <input type="hidden" id="prstamoOrigVOmodoPago" name="prstamoOrigVOmodoPago" value="${presolicitudVO.prstamoOrigVO.modoPago}"/>
                                <input type="hidden" id="prstamoOrigVOtipoCuent" name="prstamoOrigVOtipoCuent" value="${presolicitudVO.prstamoOrigVO.tipoCuenta}"/>
                                <input type="hidden" id="prstamoOrigVOtipoOd" name="prstamoOrigVOtipoOd" value="${presolicitudVO.prstamoOrigVO.tipoOd}"/>
                                <input type="hidden" id="ipMaquina" name="ipMaquina" value="${presolicitudVO.ipMaquina}"/>
                                <input type="hidden" id="saldoRef" name="saldoRef" value="${presolicitudVO.saldoRef}"/>
                                <input type="hidden" id="sueldoMensual" name="sueldoMensual" value="${presolicitudVO.sueldoMensual}"/>
                                <input type="hidden" id="deduccionesVO" name="deduccionesVO" value="${presolicitudVO.deduccionesVO}"/>
                                <input type="hidden" id="altaModFluj" name="altaModFluj" value="${presolicitudVO.altaModFluj}"/>
                                <input type="hidden" id="periodicidad" name="periodicidad" value="${presolicitudVO.periodicidad}"/>
                                <input type="hidden" id="cAntiguedadVOAnio" name="cAntiguedadVOAnio" value="${presolicitudVO.cAntiguedadVO.anio}"/>
                                <input type="hidden" id="cAntiguedadVOMes" name="cAntiguedadVOMes" value="${presolicitudVO.cAntiguedadVO.mes}"/>
                                <input type="hidden" id="cAntiguedadVODia" name="cAntiguedadVODia" value="${presolicitudVO.cAntiguedadVO.dia}"/>
                                <input type="hidden" id="cAntiguedadVOAntig" name="cAntiguedadVOAntig" value="${presolicitudVO.cAntiguedadVO.antiguedad}"/>
                                <input type="hidden" id="cAntiguedadVOconsistencia" name="cAntiguedadVOconsistencia" value="${presolicitudVO.cAntiguedadVO.consistenciaParamOtorg}"/>
                                <input type="hidden" id="cAntiguedadVOantigPerm" name="cAntiguedadVOantigPerm" value="${presolicitudVO.cAntiguedadVO.antiguedadPermitida}"/>
                                <input type="hidden" id="refinancia" name="refinancia" value="${presolicitudVO.refinancia}"/>
                                <input type="hidden" id="refinanciamientoVOldSaldoRef" name="refinanciamientoVOldSaldoRef" value="${presolicitudVO.refinanciamientoVO.ldSaldoRef}"/>
                                <input type="hidden" id="refinanciamientoVOldCapRefin" name="refinanciamientoVOldCapRefin" value="${presolicitudVO.refinanciamientoVO.ldCapRefinanc}"/>
                                <input type="hidden" id="refinanciamientoVOldIntRefin" name="refinanciamientoVOldIntRefin" value="${presolicitudVO.refinanciamientoVO.ldIntRefinanc}"/>
                                <input type="hidden" id="refinanciamientoVOldIvaRefin" name="refinanciamientoVOldIvaRefin" value="${presolicitudVO.refinanciamientoVO.ldIvaRefinanc}"/>
                                <input type="hidden" id="refinanciamientoVOlsQnasf" name="refinanciamientoVOlsQnasf" value="${presolicitudVO.refinanciamientoVO.lsQnasf}"/>
                                <input type="hidden" id="refinanciamientoVOldAmtLastP" name="refinanciamientoVOldAmtLastP" value="${presolicitudVO.refinanciamientoVO.ldAmtLastPmt}"/>
                                <input type="hidden" id="refinanciamientoVOpagoRef1" name="refinanciamientoVOpagoRef1" value="${presolicitudVO.refinanciamientoVO.pagoRef1}"/>
                                <input type="hidden" id="refinanciamientoVOpagoRef2" name="refinanciamientoVOpagoRef2" value="${presolicitudVO.refinanciamientoVO.pagoRef2}"/>
                                <input type="hidden" id="refinanciamientoVOpagoRef3" name="refinanciamientoVOpagoRef3" value="${presolicitudVO.refinanciamientoVO.pagoRef3}"/>
                            </div>
                            
                            <div class="pull-right">			
                            <c:if test="${presolicitudVO.tpoCreditoVO.cveTcr==21}">
                                    <input class="btn btn-primary" type="submit" name="botonAceptarCredito" value="Acepta préstamo" onclick="popupload();"/>
                            </c:if>
                            <c:if test="${presolicitudVO.tpoCreditoVO.cveTcr!=21}">
                                    <input class="btn btn-primary" type="submit" name="botonAceptarCredito" value="Aceptar préstamo" />
                            </c:if>
                                <input class="btn btn-danger" type="submit" name="rechazoPrest" value="Rechazar préstamo" />
                            </div>      
                        </form:form>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
