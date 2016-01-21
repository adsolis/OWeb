<%-- 
    Document   : index
    Created on : 18/07/2014, 02:07:20 PM
    Author     : jrobles
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><fmt:message key="title"/></title>
        <link rel="stylesheet" type="text/css" href="resources/style.css"/>
        <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
        <style type="text/css"> 
            <!--
            .style1 { font-size: 14px; font-family: Arial, Helvetica, sans-serif; }
            .style4 { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }
            -->
        </style>
        <style type="text/css" media="print">
            .nover {display:none}
        </style>
    </head>
    <body>
            <!--script src="http://framework-gb.cdn.gob.mx/gobmx.js"></script-->
        <form:form method="post" action="tipootorgamiento.htm" commandName="command">
            <table align="center">
                <tbody>
                    <tr><td colspan="2" bgcolor="#676767" width="520" align="center">
                            <font class="titulo"><fmt:message key="tituloDatosPersonales"/></font></td> 
                        
                    </tr>
                    <tr><td bgcolor="#fff3e3"><font color="black"> 
                                <i>Captura de Datos (Versión 2.0)</i></font></td>
                                <td bgcolor="#fff3e3"></td>
                    </tr>
                    <tr><td bgcolor="#fff3e3"> 
                    <tr>
                        <td bgcolor="#fff3e3"><form:label path="numIssste"><fmt:message key="numeroIssste"/></form:label></td>
                        <td bgcolor="#fff3e3"><form:input path="numIssste" /></td>
                    </tr>
                    <tr>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:label path="rfc"><fmt:message key="rfc"/></form:label></span></td>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:input path="rfc" /></span></td>
                    </tr>
                    <tr>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:label path="curp"><fmt:message key="curp"/></form:label></span></td>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:input path="curp"/></span></td>
                    </tr>
                    <tr>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:label path="email"><fmt:message key="email"/></form:label></span></td>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:input path="email"/></span></td>
                    </tr>
                    <tr>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:label path="cemail"><fmt:message key="confirmEmail"/></form:label></span></td>
                        <td align="left" bgcolor="#fff3e3"><span class="style4"><form:input path="cemail"/></span></td>
                    </tr>
                    <tr>
                        <td align="left" bgcolor="#fff3e3"><input type="submit" value="Verificar"></td>
                        <td align="left" bgcolor="#fff3e3"><input type="reset" value="Limpiar"></td>  
                    </tr>
                    </td></tr>
                    <tr><td bgcolor="#fff3e3"></td>
                        <td bgcolor="#fff3e3"></td>
                    </tr>
                </tbody>

            </table>  
        </form:form>
    </body>
</html>