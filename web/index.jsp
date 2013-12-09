<%-- 
    Document   : index
    Created on : 16-nov-2013, 17:40:36
    Author     : miklex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.Vector, com.tux.ws.ContpaqWS" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try {
                ContpaqWS form = new ContpaqWS();
                String result = form.hello("prueba");
                out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
