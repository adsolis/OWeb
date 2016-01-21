<%-- 
    Document   : encabezado
    Created on : 9/09/2014, 09:30:57 PM
    Author     : ucol
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="windows-1252" %>
<!DOCTYPE html>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <body >
        <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->
        <!--main role="main"-->
            <!--div class="container"-->
                <!--div class="row"-->
                    <!--div class="col-md-8"-->
                            <h3>
                                <fmt:message key="bienvenida"/>${sessionScope.datoslaboralesvo.nombreCompleto}
                            </h3>
                    <!--/div-->
                <!--/div-->
            <!--/div-->
        <!--/main-->
    </body>
</html>
