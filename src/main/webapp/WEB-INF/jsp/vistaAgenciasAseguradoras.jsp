<%-- 
    Document   : vistaAgenciasAseguradoras
    Created on : 10/09/2014, 09:42:00 PM
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
                        <c:if test="${varAgen==0}">

                            <table class="table table-striped">
                                <th ><h4><fmt:message key="etq.titulo.agencia"/></h4></th>

                                <c:forEach items="${agencias}" var="agencia">
                                    <tr >
                                    <img  width="80" height="80"  src="img/${agencia.nomImagen}"/>
                                    <td>
                                        <a href="${agencia.url}" target="_blank">${agencia.url}</a>
                                    </td>
                                    </tr>

                                </c:forEach>
                            </table>
                        </c:if>

                        <c:if test="${varAseg==0}">                        
                            <table class="table table-striped">
                                <th ><h4><fmt:message key="etq.titulo.aseguradoras"/></h4></th>

                                <c:forEach items="${aseguradoras}" var="aseguradora">
                                    <tr >
                                    <img  width="80" height="80" src="img/${aseguradora.nomImagen}"/>
                                    <td>
                                        <a href="${aseguradora.url}" target="_blank">${aseguradora.url}</a>
                                    </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                    </div>
                </div>
            </div>
    </body>
</html>
