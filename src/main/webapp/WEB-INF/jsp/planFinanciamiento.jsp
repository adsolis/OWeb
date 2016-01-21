<%-- 
    Document   : planFinanciamiento
    Created on : 25/10/2014, 01:22:28 PM
    Author     : VPEREZ
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>


<%@page contentType="text/html" pageEncoding="windows-1252" %>

<!DOCTYPE html>
<html>
    <style type="text/css" media="print">
        .nover {display:none}
    </style>
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
        <!--  Impresión de enabezado -->
    <tr>
        <td class="nover">
            <jsp:include page="encabezado.jsp"/>
        </td>
    </tr>

    <table align="center" class="nover" border="0" width="585" bgcolor="F2F2F2"> <tr> <td> 

                <form id="accionForm" action="SimulacionCredito.pdf" method="post">
                    <input type="hidden" id="descargar" name="descargar" />
                    <table align="center" class="nover">
                        <tr>
                        <input type="hidden" id="apPaterno" name="apPaterno"    value="${presol.directo.apellidoPaterno}"/>  
                        <input type="hidden" id="apMaterno" name="apMaterno"    value="${presol.directo.apellidoMaterno}"/>  
                        <input type="hidden" id="nombre"    name="nombre"       value="${presol.directo.nombre}"/>  
                        <input type="hidden" id="rfc"       name="rfc"          value="${presol.directo.rfc}"/>  
                        <input type="hidden" id="anio"      name="anio"         value="${presol.cAntiguedadVO.anio}"/>  
                        <input type="hidden" id="mes"       name="mes"          value="${presol.cAntiguedadVO.mes}"/>  
                        <input type="hidden" id="dias"       name="dias"          value="${presol.cAntiguedadVO.dia}"/>  
                        <input type="hidden" id="numIssste" name="numIssste"    value="${presol.directo.numIssste}"/>  
                        <input type="hidden" id="cveCat"    name="cveCat"       value="${presol.cramPagVO.ramoCat}"/>  
                        <input type="hidden" id="descRamo" name="descRamo"      value="${presol.descRamo}"/>  
                        <input type="hidden" id="sueldoMensual" name="sueldoMensual"    value="${presol.sueldoMensual}"/>  
                        <input type="hidden" id="cvePag" name="cvePag"  value="${presol.cramPagVO.pagaCat}"/>  
                        <input type="hidden" id="descPag" name="descPag"  value="${presol.cramPagVO.nombCat}"/>  
                        <input type="hidden" id="dsctoFovissste" name="dsctoFovissste"  value="${presol.deduccionesVO}"/>  
                        <input type="hidden" id="montoSol" name="montoSol"  value="${presol.prstamoOrigVO.origLoanPrin}"/>  
                        <input type="hidden" id="descMontoSol" name="descMontoSol"  value="${presol.descMontoSol}"/>  
                        <input type="hidden" id="saldoAnt" name="saldoAnt"  value="${presol.saldoRef}"/>  
                        <input type="hidden" id="primaGarantia" name="primaGarantia"  value="${presol.prstamoOrigVO.warrantyPrem}"/>  
                        <input type="hidden" id="primaRenovacion" name="primaRenovacion"  value="${presol.prstamoOrigVO.renewalPrem}"/>  
                        <input type="hidden" id="impCheque" name="impCheque"  value="${presol.prstamoOrigVO.impLiquido}"/>  
                        <input type="hidden" id="descImporteCheque" name="descImporteCheque"  value="${presol.descImporteCheque}"/>  
                        <input type="hidden" id="desctoAmt" name="desctoAmt"  value="${presol.prstamoOrigVO.payAmt}"/>  
                        <input type="hidden" id="tasaInt" name="tasaInt"  value="${presol.prstamoOrigVO.intRate}"/>  
                        <input type="hidden" id="plazoAmort" name="plazoAmort"  value="${presol.prstamoOrigVO.origNbrPay}"/>  
                        <input type="hidden" id="iniDesc" name="iniDesc"  value="${presol.prstamoOrigVO.firstPayPerYrD}"/>  
                        <input type="hidden" id="finDesc" name="finDesc"  value="${presol.prstamoOrigVO.lastPayPerYrDu}"/>  
                        <input type="hidden" id="descDtoAmt" name="descDtoAmt" value="${presol.descDtoAmt}"/>
                        <input type="hidden" id="tipoPrest" name="tipoPrest"    value="${presol.tpoCreditoVO.nomTcr}"/> 

<!--                            <td align="left"><input type="submit" class="nover" id="btnImprimir" value="Imprimir"  ></td>		    -->
                            <td align="left"><input type="button" class="nover" id="btnImprimir" value="Imprimir" onclick="window.print();" ></td>		    
                            <td align="left"><input type="button" class="nover" id="btnBajar"  name="btnBajar" value="Guardar" onclick="document.getElementById('descargar').value='save';document.getElementById('accionForm').submit();"> </td>
                            <td align="left"><input type="button" class="nover" id="btnCerrar" name="btnCerrar" value="Cerrar Ventana" onclick="window.close()"></td>
                        </tr>	
                    </table>
                </form>
            </td> </tr> </table>
    <table align="center" align="center" width="730">
        <tr><td width="80">&nbsp;
            </td></tr>
        <tr><td width="650">
                <table align="center"> 
                    <tr><td width="650"> 
                            <table align="center" width="650"> 
                                <tr><td width="75" align="center"><img src="img/logo_der.jpg" width="150" height="150"/></td>
                                    <td align="center">
                                        <table style="font-size:16px;font-family:arial" width="350">
                                            <tr><td align="center" ><b><fmt:message key="titulo.simulacion.plan"/></b></td></tr> 
                                            <tr><td align="center"> 
                                                    <b><fmt:message key="titulo.simulacion.prestamo" />  ${presol.tpoCreditoVO.nomTcr} </b> 
                                                </td></tr>
                                        </table>  
                                    </td>
                                    <td><img src="img/logo_izq.jpg" width="150" height="150"/></td> 
                                </tr>
                            </table>
                        </td></tr>
                </table>

                <table style="float: left;" align="left">
                    <tr><td width="80"><img src="img/ISSSTE.jpg" width="76" height="720"/></td></tr> 
                </table> 

                <!-------            DATOS DEL SOLICITANTE   ---------->
                <table style="font-size:16px;font-family:arial;text-align:center">  
                    <tr><td width="600"><b><u><fmt:message key="tituloDatosSolicitante"/></u></b> 
                        </td></tr>
                    <tr><td><br>

                            <table cellspacing="0" cellpadding="-1" style="font-size:7px;font-family:arial">
                                <tr style="font-size:11px;font-family:arial"> 
                                    <td align="center" width="200"> <b>${presol.directo.apellidoPaterno}</b>  
                                    </td>
                                    <td align="center"> <b>${presol.directo.apellidoMaterno}</b> 	
                                    </td>
                                    <td align="center"> <b>${presol.directo.nombre}</b>
                                    </td>	
                                </tr> 
                                <tr> 
                                    <td align="center" width="200"> - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	</td>
                                    <td align="center"> - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 		</td>
                                    <td align="center"> - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - -		</td>	
                                </tr> 
                                <tr> 
                                    <td align="center" width="200"><fmt:message key="etq.simulado.ap_materno"/></td>
                                    <td align="center" width="200"><fmt:message key="etq.simulado.ap_materno"/></td>
                                    <td align="center" width="200"><fmt:message key="etq.simulado.nombre"/></td>
                                </tr> 
                            </table>

                        </td></tr>
                    <tr><td><br>

                            <table cellpadding="-1" style="font-size:9px;font-family:arial" align="center">
                                <tr>
                                    <td align="center"  width="150"> <b>${presol.directo.rfc}</b> <!-- Aqui va el rfc -->	
                                    </td>
                                    <td align="center" width="250"> <b>${presol.cAntiguedadVO.anio} <fmt:message key="etiqAnios"/> ${presol.cAntiguedadVO.mes} <fmt:message key="etiqMes"/> ${presol.cAntiguedadVO.dia} <fmt:message key="etiqDias"/> </b> <!-- Aqui va el curp -->
                                    </td>	
                                    <td align="center"  width="120"> <b>${presol.directo.numIssste}</b> <!-- Aqui va el num issste -->	
                                    </td>
                                </tr> 
                                <tr>	
                                    <td align="center"> - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                    </td>
                                    <td align="center"> - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 	
                                    </td>
                                    <td align="center"> - - - - - - - - - - - - - - - - - - 	
                                    </td>
                                </tr> 
                                <tr> 
                                    <td align="center" width="200"><fmt:message key="etq.simulado.rfc"/></td>
                                    <td align="center" width="250"><fmt:message key="etq.simulado.antiguedad"/></td>
                                    <td align="center" width="180"><fmt:message key="etq.simulado.num_issste"/></td>
                                </tr> 
                            </table>	

                        </td></tr>
                    <tr><td><br>

                            <!-------            DATOS LABORALES   ---------->
                            <table style="font-size:8px;font-family:arial">
                                <tr><td width="650" align="left"><b><fmt:message key="titulo.simulado.datos_lab"/></b></td>
                                </tr> 
                            </table> 
                            <br>

                        </td></tr>
                    <tr><td>

                            <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0"> 
                                <tr> 
                                    <td width="120" align="center" > <b>${presol.cramPagVO.ramoCat}</b> <!--  Clave del Ramo --> 
                                    </td> 
                                    <td width="340" align="center" > <b>${presol.descRamo}</b> <!--  Nombre del Ramo --> 
                                    </td>
                                    <td width="200" align="center" > <b><fmt:formatNumber value="${presol.sueldoMensual}" pattern="###,###,##0.00"/></b> <!--  Sueldo básico del Ramo -->
                                    </td>
                                </tr>
                                <tr> 
                                    <td align="center" >- - - - - - - - - - - - - - - - - - - 
                                    </td> 
                                    <td align="center" > - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
                                    </td>
                                    <td align="center" >  - - - - - - - - - - - - - - - - - - - - - - - - - -
                                    </td>
                                </tr> 
                                <tr> 
                                    <td align="center"><fmt:message key="etq.simulado.cve_ramo"/></td> 
                                    <td align="center"><fmt:message key="etq.simulado.nom_ramo"/></td>
                                    <td align="center"><fmt:message key="etq.simulado.sueldo_bas_men"/></td>
                                </tr> 
                            </table> 

                        </td></tr>
                    <tr><td>

                            <br>
                            <!--              -->
                            <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                <tr> 
                                    <td width="120" align="center" > <b>${presol.cramPagVO.pagaCat}</b> <!--  Clave de Pagaduría --> 
                                    </td> 
                                    <td width="340" align="center" > <b>${presol.cramPagVO.nombCat}</b> <!--  Nombre de la Pagaduria --> 
                                    </td>
                                    <td width="200" align="center" >  <b>${presol.deduccionesVO}</b> <!--  Deducciones foviste-->
                                    </td>
                                </tr>
                                <tr> 
                                    <td align="center" >- - - - - - - - - - - - - - - - - - - 
                                    </td> 
                                    <td align="center" > - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
                                    </td>
                                    <td align="center" >  - - - - - - - - - - - - - - - - - - - - - - - - - -
                                    </td>
                                </tr> 
                                <tr> 
                                    <td width="150" Align="center"><fmt:message key="etq.simulado.cve_pag"/></td> 
                                    <td width="400" Align="center"><fmt:message key="etq.simulado.nom_pag"/></td>
                                    <td width="200" Align="center"><fmt:message key="etq.simulado.ded_fovisste"/></td>
                                </tr> 
                            </table>	

                        </td></tr>

                </table><!-- End table datos del solicitante --> 

                <!-------           DATOS DEL PRÉSTAMO  ---------->


                <br>
                <table style="font-size:16px;font-family:arial;text-align:center">	
                    <tr><td width="600"><b><u><fmt:message key="etq.simulado.datos_prestamo"/></u></b></td> 
                    </tr>
                    <tr><td>
                            <table border="1"><tr><td><br>

                                        <table style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.importe_prestamo"/></td> 
                                                <td width="150" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.origLoanPrin}" maxFractionDigits="2" pattern="###,###,##0.00" /></b>  <!-- Monto con número  --> 
                                                </td>
                                                <td width="300" align="center" > <b>${presol.descMontoSol}</b>  <!--  Monto con letra -->
                                                </td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td width="300" align="center" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - -
                                                </td>
                                            </tr> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="LEFT"> 	   </td> 
                                                <td width="150" align="CENTER"><fmt:message key="etq.simulado.numero"/></td>
                                                <td width="300" align="center"><fmt:message key="etq.simulado.letra"/></td>
                                            </tr> 
                                        </table>

                                        <!--    -->   
                                        <br>
                                        <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.saldo_anterior"/></td> 
                                                <td width="150" align="center" > <b>${presol.saldoRef}</b> <!-- Saldo del préstamo anterior --> 
                                                </td>
                                                <td width="300" align="center" > 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td  > 
                                                </td>
                                            </tr> 
                                        </table> 

                                        <!--    -->   
                                        <br>
                                        <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.prima_garantia"/>  
                                                </td> 
                                                <td width="150" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.warrantyPrem}" pattern="###,###,##0.00"/></b> <!-- Prima de Garantía --> 
                                                </td>
                                                <td width="300" align="center" >  
                                                </td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td  align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" > 
                                                </td>
                                            </tr> 
                                        </table> 

                                        <!--    -->   
                                        <br>
                                        <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.prima_renovacion"/></td> 
                                                <td width="150" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.renewalPrem}" pattern="###,###,##0.00"/></b> <!--Prima de renovacion --> 
                                                </td>
                                                <td width="300" align="center" >  
                                                </td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td  align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" > 
                                                </td>
                                            </tr>  
                                        </table>

                                        <!--    -->   
                                        <br>
                                        <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.importe_cheque"/></td> 
                                                <td width="150" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.impLiquido}" pattern="###,###,##0.00"/></b> <!-- Importe del cheque --> 
                                                </td>
                                                <td width="300" align="center" > <b>${presol.descImporteCheque}</b>  <!-- Importe del cheque con letra -->
                                                </td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" >- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - -
                                                </td>
                                            </tr> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td align="LEFT" > 
                                                </td> 
                                                <td align="center" ><fmt:message key="etq.simulado.numero"/></td>
                                                <td align="center" ><fmt:message key="etq.simulado.letra"/></td>
                                            </tr> 
                                        </table>

                                        <!--    -->   

                                        <table  style="font-size:7px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.dscto_amto"/>  
                                                </td> 
                                                <td width="150" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.payAmt}" pattern="###,###,##0.00"/></b> <!-- Descuento de amortización --> 
                                                </td>
                                                <td width="300" align="center" > <b>${presol.descDtoAmt}</b>  <!-- Importe del cheque con letra -->
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td  align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" >- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - -
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td align="LEFT" > 
                                                </td> 
                                                <td align="center" ><fmt:message key="etq.simulado.numero"/></td>
                                                <td align="center" ><fmt:message key="etq.simulado.letra"/></td>
                                            </tr>     
                                        </table>    

                                        <!--    -->   
                                        <br>




                                        <table  style="font-size:7px;font-family:arial;align:center"  cellspacing="0" cellspacing="0"> 
                                            <tr>
                                                <td width="140" align="center" > <b><fmt:formatNumber value="${presol.prstamoOrigVO.intRate}" pattern="###'%'"/></b> <!--  Tasa de Intereses  -->
                                                </td> 
                                                <td width="140" align="center" > <b>${presol.prstamoOrigVO.origNbrPay}</b> <!-- Plazo de Amortización --> 
                                                </td>
                                                <td width="140" align="center" > <b>${presol.prstamoOrigVO.firstPayPerYrD}</b> <!-- Inicio del descuento --> 
                                                </td>
                                                <td width="140" align="center" > <b>${presol.prstamoOrigVO.lastPayPerYrDu}</b> <!-- Fin del descuento --> 
                                                </td>
                                            </tr>

                                            <tr>
                                                <td align="center" > - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" >  - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" > - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                                <td align="center" > - - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td align="center" ><fmt:message key="etq.simulado.tasa_int"/></td> 
                                                <td align="center" ><fmt:message key="etq.simulado.pzoP_amto"/></td>
                                                <td align="center" ><fmt:message key="etq.simulado.ini_dscto"/></td>
                                                <td align="center" ><fmt:message key="etq.simulado.fin_dscto"/> 
                                                </td>
                                            </tr> 
                                            <tr> 
                                                <td colspan="4" style="font-size:7px;font-family:arial;text-align:justify"><br><br>
                                                    <table>
                                                        <tr>
                                                            <td><fmt:message key="etq.simulado.nota.acuse"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><fmt:message key="etq.simulado.nota.proteccion_datos"/></td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>

                                        </table>  

                                    </td></tr>

                            </table> <!-- end table border=1 -->

                        </td></tr>

                    <tr><td>

                            <!-------      FOOTER    ---------->
                            <br>
                            <table style="font-size:12px;font-family:times;text-align:center">
                                <tr>
                                    <td width="600">
                                        <b><u><fmt:message key="etq.simulado.nota.info"/></u></b>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table style="font-size:10px;font-family:times;text-align:center" width="600"> 
                                            <tr><td > <b><fmt:message key="etq.simulado.pie.issste"/></b></td>
                                            </tr> 
                                            <tr><td> <b><fmt:message key="etq.simulado.pie.dpesc"/></b></td>
                                            </tr> 
                                            <tr><td> <b><fmt:message key="etq.simulado.pie.subdir_oto"/></b></td>
                                            </tr> 
                                        </table> 

                                    </td>
                                </tr>

                            </table>  	  

                        </td></tr>
                </table> <!-- End table DATOS DEL PRÉSTAMO -->
                <br>
                <br>

            </td></tr>
        <!-- Final del contenido  -->
    </table>


</body>
</html>
	