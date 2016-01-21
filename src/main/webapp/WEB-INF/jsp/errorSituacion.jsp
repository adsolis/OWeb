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
        <<link rel="stylesheet" type="text/css" href="resources/style.css"/>
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

                    <!--Es necesario que usted aclare su situacion afiliatoria a traves de las oficinas de Prestaciones del ISSSTE-->
                        <div class="col-md-8">
                            <jsp:include page="encabezado.jsp"/>
                        </div>
                        <div class="row">
                            <div class="col-sm-11">
                                <div class="vertical-buffer">
                                    <div class="alert alert-danger">
                                        <strong>Error:</strong>
                                        ${exception.message}
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-8">
                            <button type="submit" name="Regresar" onclick="history.back()" id="btnAceptar" class="btn btn btn-primary ">Regresar</button>
                        </div>
                </div>
        </main> 
    </body>
</html>
