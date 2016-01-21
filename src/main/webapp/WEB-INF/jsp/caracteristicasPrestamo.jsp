<%-- 
    Document   : seleccionPrestamo
    Created on : 10/09/2015, 09:42:00 PM
    Author     : ucol
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-eqiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                        <jsp:include page="encabezado.jsp"/>
                    </div>
                    <div class="col-md-8">
                        <img width="750"  src="img/caracpres.PNG"/>
                    </div>
                    <div class="form-group vertical-buffer">
                        <a href="javascript:window.close();" class="cierre">
                            Cerrar Ventana 
                        </a>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
