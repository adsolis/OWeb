<%-- 
    Document   : seleccionPrestamo
    Created on : 9/09/2015, 09:42:00 PM
    Author     : UCOL
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
        <link href="resources/gobmx_estilos/assets/css/gobmx.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,300' rel='stylesheet' type='text/css'>

    </head>

    <body>
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->
        <main class="page">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <jsp:include page="encabezado.jsp"/>

                        <div class="vertical-buffer">
                            <h2 class="vertical-buffer"><fmt:message key="tituloSeleccionPrestamos"/></h2>
                            <hr class="red">

                            <form:form action="simulacion.htm" method="POST" onsubmit="document.getElementById('action').value='regresa'">

                                <form:form id="seleccionPrestamoForm" name="seleccionPrestamoForm" action="simulacion.htm" method="POST" commandName="seleccionPrestamoForm">
                                    <input type="hidden" id="tipoPrestamo" name="tipoPrestamo"/>
                                    <input type="hidden" id="action" name="action" value="validaPrestamoSimulado"/>
                                    <div class="btn-group-vertical" role="group">
                                        <c:forEach items="${prestamosList}" var="prestamo">
                                            <a  href="javascript:;" onclick="document.getElementById('tipoPrestamo').value = '${prestamo.cveTcr}';
                                                    document.getElementById('command').submit();" class="btn btn-default">
                                                ${prestamo.nomTcr}</a>

                                        </c:forEach>
                                    </div>
                                    <div class="" >
                                        <a class="btn btn-default  top-buffer" name="btnRegresa"
                                           onclick='history.back()'>

                                            <span class="glyphicon glyphicon-arrow-left"></span>
                                            Anterior

                                        </a>
                                    </div>
                                </form:form>
                            </form:form>
                        </div>
                    </div> 
                </div>
            </div>
        </main>
    </body>
</html>
