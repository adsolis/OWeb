    <%-- 
    Document   : tipootorgamiento
    Created on : 8/09/2014, 11:46:20 PM
    Author     : jrobles
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><fmt:message key="title"/></title>
        <style type="text/css"> 
            <!--
            .style1 { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }
            .style4 { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }
            -->
        </style>
        <link rel="stylesheet" type="text/css" href="resources/style.css"/>
        <link href="resources/gobmx_estilos/assets/css/gobmx.css" rel="stylesheet">
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300'
	rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body Topmargin="0px" Bottommargin="0px">
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->

        <!--main role="main"-->
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <jsp:include page="encabezado.jsp"/>
                            <br>
				<h2 class="">Opciones</h2>
				<hr class="red">

                        <div class="btn-group btn-group-justified" role="group">
                            <form:form id="simulacionForm" action="simulacion.htm" method="POST" commandName="command">
                          
                                    <input type="hidden" id="action" name="action" value="inicio"/>
                                    <a  href="javascript:document.getElementById('action').value='inicio';document.getElementById('simulacionForm').submit();" class="btn btn-default"> Simulación </a>
                          
                            </form:form>    

                            <form:form id="otorgamientoForm" action="otorgamiento.htm" method="POST" commandName="command">

                                <input type="hidden" id="issste" name="issste" value="${personaDirecto.numIssste}"/>
                                <input type="hidden" id="rfc" name="rfc" value="${personaDirecto.rfc}"/>
                                <input type="hidden" id="curp" name="curp" value="${personaDirecto.curp}"/>
                                <input type="hidden" id="nombre" name="nombre" value="${personaDirecto.nombre}"/>
                                <input type="hidden" id="aPaterno" name="aPaterno" value="${personaDirecto.apellidoPaterno}"/>
                                <input type="hidden" id="aMaterno" name="aMaterno" value="${personaDirecto.apellidoMaterno}"/>
                                <input type="hidden" id="aMaterno" name="aMaterno" value="${personaDirecto.entCve}"/>
                                    <a href="javascript:document.getElementById('otorgamientoForm').submit();"  class="btn btn-default"> Otorgamiento </a>
                          
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        <!--/main-->
    </body>
</html>