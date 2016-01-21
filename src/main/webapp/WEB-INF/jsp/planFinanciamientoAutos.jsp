    <%-- 
    Document   : imprimirPlanFinanciamiento
    Created on : 10/09/2014, 09:42:00 PM
    Author     : ucol
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

                <form id="accionForm" action="PrestamosAnterioresAutosDescargar.pdf" method="post">
                    <input type="hidden" id="descargar" name="descargar" />
                    <table align="center" class="nover">
                        <tr>
                            <td colspan="3" style="font-size:12px;font-family:arial" align="left"><fmt:message key="etq.planfinanc.nota"/></td>		    
                        </tr>
                        <tr>
                            <td align="center">
                                <input type="hidden" id="tipoPrest" name="tipoPrest"    value="${presol.tpoCreditoVO.nomTcr}"/> 
                                <input type="hidden" id="folioSol" name="folioSol"    value="${presol.folioSol}"/> 
                                <input type="hidden" id="cveAfect" name="cveAfect"    value="${presol.prstamoOrigVO.cveAfect}"/> 
                                <input type="hidden" id="caja" name="caja"    value="${presol.coberturaGlobVO.oficina.cveOficina}"/> 
                                <input type="hidden" id="apPaterno" name="apPaterno"    value="${presol.directo.apellidoPaterno}"/>  
                                <input type="hidden" id="apMaterno" name="apMaterno"    value="${presol.directo.apellidoMaterno}"/>  
                                <input type="hidden" id="nombre"    name="nombre"       value="${presol.directo.nombre}"/>  
                                <input type="hidden" id="rfc"       name="rfc"          value="${presol.directo.rfc}"/>  
                                <input type="hidden" id="curp"      name="curp"         value="${presol.directo.curp}"/>  
                                <input type="hidden" id="numIssste" name="numIssste"    value="${presol.directo.numIssste}"/>  
                                <input type="hidden" id="cveCat"    name="cveCat"       value="${presol.cramPagVO.ramoCat}"/>  
                                <input type="hidden" id="descRamo" name="descRamo"      value="${presol.descRamo}"/>  
                                <input type="hidden" id="sueldoMensual" name="sueldoMensual"    value="${presol.sueldoMensual}"/>  
                                <input type="hidden" id="cvePag" name="cvePag"  value="${presol.cramPagVO.pagaCat}"/>  
                                <input type="hidden" id="descPag" name="descPag"  value="${presol.cramPagVO.nombCat}"/>  
                                <input type="hidden" id="dsctoFovissste" name="dsctoFovissste"  value="${presol.deduccionesVO}"/>  
                                <input type="hidden" id="numeroPrestamo" name="numeroPrestamo"  value="${presol.prstamoOrigVO.auxNumPrestamo}"/>  
                                <input type="hidden" id="fechaPrestamo" name="fechaPrestamo"  value="${presol.prstamoOrigVO.auxFechaPrestamo}"/>  
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
                                <input type="hidden" id="calle" name="calle"  value="${presol.cajaPagadoraVO.calle}"/> 
                                <input type="hidden" id="colonia" name="colonia"  value="${presol.cajaPagadoraVO.colonia}"/> 
                                <input type="hidden" id="codigo" name="codigo"  value="${presol.cajaPagadoraVO.codigoPostal}"/> 
                                <input type="hidden" id="ciudad" name="ciudad"  value="${presol.cajaPagadoraVO.ciudad}"/> 
                                <input type="hidden" id="entidad" name="entidad"  value="${presol.cajaPagadoraVO.entidad}"/> 
                                <input type="button" class="nover" id="btnImprimir" value="Imprimir" onclick="window.print();" />	    
                                <input type="button" class="nover" id="btnBajar"  name="btnBajar" value="Guardar" onclick="document.getElementById('descargar').value='save';document.getElementById('accionForm').submit();"/>
                                <input type="button" class="nover" id="btnCerrar" name="btnCerrar" value="Cerrar Ventana" onclick="window.close()"/>

                            </td>
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
                                <tr><td width="75" align="center"><img src="img/logo_izq.jpg" width="100" height="100"/></td>
                                    <td align="center">
                                        <table style="font-size:16px;font-family:arial" width="350">
                                            <tr><td align="center" ><b><fmt:message key="etq.planfinanc.titulo"/></b></td></tr> 
                                            <tr><td align="center"> 
                                                    <b>${presol.tpoCreditoVO.nomTcr} <!-- Tipo de Crédito (Descripción) --></b> 
                                                </td></tr>
                                        </table>  
                                    </td>
                                    <td><img src="img/logo_der.jpg" width="100" height="100"/></td> 
                                </tr>
                            </table>
                        </td></tr>
                </table>

                <table style="float: left;" align="left">
                    <tr><td width="80"><img src="img/leyenda_izq.PNG" width="76" height="720"/></td></tr> 
                </table> 

                <!-------            DATOS DEL SOLICITANTE   ---------->
                <table style="font-size:8px;font-family:arial;text-align:center">  
                    <tr>
                        <td>
                            <table cellspacing="0" align="right" cellpadding="-1" style="font-size:12px;font-family:arial">
                                <tr>
                                    <td>
                                        <fmt:message key="etq.planfinanc.folioNum"/>
                                    </td>
                                    <td colspan="3" style="text-align: left">
                                        <b>
                                            ${presol.folioSol}
                                        </b>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                        <table style="background: #D8D8D8; text-align: left; " width="200">
                                            <tr>
                                                <td colspan="2"> 
                                                    <fmt:message key="etq.planfinanc.afecta"/>
                                                </td>
                                                <td style="text-align: left">
                                                        ${presol.prstamoOrigVO.cveAfect}
                                                </td>
                                                <td>
                                                    <fmt:message key="etq.planfinanc.caja"/>
                                                </td>
                                                <td>
                                                        ${presol.coberturaGlobVO.oficina.cveOficina}
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr><td width="600" style="text-align: left"><b><fmt:message key="tituloDatosSolicitante"/></b> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <br/>

                            <table cellspacing="0" cellpadding="-1" style="font-size:8px;font-family:arial">
                                <tr style="font-size:8px;font-family:arial"> 
                                    <td align="center" width="200">${presol.directo.apellidoPaterno} 
                                    </td>
                                    <td align="center">${presol.directo.apellidoMaterno}	
                                    </td>
                                    <td align="center">${presol.directo.nombre}
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

                            <table cellpadding="-1" style="font-size:8px;font-family:arial" align="center">
                                <tr>
                                    <td align="center"  width="150"> <b>${presol.directo.rfc}</b> <!-- Aqui va el rfc -->	
                                    </td>
                                    <td align="center" width="250"> <b>${presol.directo.curp} </b> <!-- Aqui va el curp -->
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
                                    <td align="center" width="250"><fmt:message key="etq.planfinanc.curp.reg"/></td>
                                    <td align="center" width="180"><fmt:message key="etq.simulado.num_issste"/></td>
                                </tr> 
                            </table>	

                        </td>
                    </tr>
                </table><!-- End table datos del solicitante --> 

                <!-------           DATOS DEL PRÉSTAMO  ---------->


                <br>
                <table style="font-size:8px;font-family:arial;text-align:center">	
                    <tr><td width="600" align="left"><b><fmt:message key="etq.simulado.datos_prestamo_auto"/></b></td> 
                    </tr>
                    <tr><td>
                            <table border="1"><tr><td><br>

                                        <table style="font-size:8px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.planfinanc.auto.importeMaximo"/></td> 
                                                <td width="150" align="center" > <b><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber value="${presol.prstamoOrigVO.origLoanPrin}" maxFractionDigits="2" pattern="###,###,##0.00" /></b>  <!-- Monto con número  --> 
                                                </td>
                                                <td width="300" align="center" > <b>${presol.descMontoSol}</b>  <!--  Monto con letra -->
                                                </td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="LEFT" > 
                                                </td> 
                                                <td width="150" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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
                                        <br/>
                                        <table  style="font-size:8px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.prima_garantia"/>  
                                                </td> 
                                                <td width="450" align="center" ><fmt:message key="etq.planfinanc.auto.primaGaran"/> <!-- Prima de Garantía --> 
                                                </td>
                                            </tr>
                                        </table> 
                                        <br/>
                                        <!--    -->   

                                        <table  style="font-size:8px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="120" align="left" ><fmt:message key="etq.simulado.dscto_amto"/>  
                                                </td> 
                                                <td width="150" align="center" > <b><fmt:message key="etiqSignoPeso"/> <fmt:formatNumber value="${presol.prstamoOrigVO.payAmt}" pattern="###,###,##0.00"/></b> <!-- Descuento de amortización --> 
                                                </td>
                                                <td width="120" align="left" ><fmt:message key="etq.planfinanc.auto.fechaTramite"/>  
                                                </td> 
                                                <td width="150" align="center" > <b>${presol.prstamoOrigVO.auxFechaPrestamo}</b> <!-- Descuento de amortización --> 
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td  align="left" >
                                                </td>
                                                <td  align="center" >  - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td> 
                                                <td  align="left" >
                                                </td>
                                                <td align="center" >  - - - - - - - - - - - - - - - - - - - - - - - -
                                                </td>
                                            </tr> 
                                            <tr>
                                                <td width="15">&nbsp;</td>
                                                <td align="LEFT" > 
                                                </td> 
                                                <td align="center" ><fmt:message key="etq.simulado.numero"/></td>
                                                <td align="center" ></td>
                                            </tr>     
                                        </table>    

                                        <!--    -->   
                                        <br>




                                        <table  style="font-size:8px;font-family:arial;align:center"  cellspacing="0" cellspacing="0"> 
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
                                            <tr><td><br/></td></tr>
                                        </table>  

                                    </td></tr>

                            </table> <!-- end table border=1 -->

                        </td></tr>
                    <tr><td><br/></td></tr>
                   <tr><td width="600" align="left"><b><fmt:message key="etq.planfinanc.auto.prestamoPreAut"/></b></td> 
                    </tr>
                    <tr>
                        <td>
                            <table border="1"> 
                                <tr><td><br>
                                        <table style="font-size:8px;font-family:arial" align="center" cellspacing="0" cellspacing="0"> 
                                            <tr> 
                                                <td width="600" colspan="4" align="left"><fmt:message key="etq.planfinanc.auto.nota"/></td>

                                            </tr>
                                            <tr>
                                                <td><br/></td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" >${presol.cajaPagadoraVO.calle}</td> 
                                                <td width="50"> &nbsp; </td>
                                                <td width="150" align="left" ></td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" > - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  </td>
                                                <td width="50" > &nbsp;</td> 
                                                <td width="200" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </td>
                                            </tr> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left"><fmt:message key="etq.planfinanc.caja.calle"/></td>
                                                <td width="50">&nbsp; </td> 
                                                <td width="150" align="left"><fmt:message key="etq.planfinanc.caja.numero"/></td>
                                            </tr> 

                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" >${presol.cajaPagadoraVO.colonia}</td> 
                                                <td width="50"> &nbsp; </td>
                                                <td width="200" align="left" >${presol.cajaPagadoraVO.codigoPostal}</td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" > - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  </td>
                                                <td width="50" > &nbsp;</td> 
                                                <td width="200" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </td>
                                            </tr> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left"><fmt:message key="etq.planfinanc.caja.colonia"/></td>
                                                <td width="50">&nbsp; </td> 
                                                <td width="200" align="left"><fmt:message key="etq.planfinanc.caja.cp"/></td>
                                            </tr>

                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" >${presol.cajaPagadoraVO.ciudad}</td> 
                                                <td width="50"> &nbsp; </td>
                                                <td width="200" align="left" >${presol.cajaPagadoraVO.entidad}</td>
                                            </tr>
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left" > - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  </td>
                                                <td width="50" > &nbsp;</td> 
                                                <td width="200" align="left" >  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - </td>
                                            </tr> 
                                            <tr> 
                                                <td width="15">&nbsp;</td>
                                                <td width="500" align="left"><fmt:message key="etq.planfinanc.caja.ciudad"/></td>
                                                <td width="50">&nbsp; </td> 
                                                <td width="200" align="left"><fmt:message key="etq.planfinanc.caja.estado"/></td>
                                            </tr>
                                        </table>
                                        <br/>
                                        <table  style="font-size:8px;font-family:arial; text-align: left;" align="left" cellspacing="0" cellspacing="0">
                                            <tr><td><b><fmt:message key="etq.planfinanc.auto.nota.pie"/></b></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoUno"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoDos"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoTres"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoCuatro"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoCinco"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoSeis"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePuntoSiete"/></td></tr>
                                            <tr><td><br/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.pieS"/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePA"/></td></tr>
                                            <tr><td><br/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.auto.nota.piePAA"/></td></tr>
                                            <tr><td><br/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.nota.pieSS"/></td></tr>
                                            <tr><td><br/></td></tr>
                                            <tr><td><fmt:message key="etq.planfinanc.nota.pieF"/></td></tr>
                                            <tr><td><br/></td></tr>
                                        </table>

                                    </td></tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table> <!-- End table DATOS DEL PRÉSTAMO -->
    <br>
    <br>

</td></tr>
<!-- Final del contenido  -->
</table>


</body>
</html>
