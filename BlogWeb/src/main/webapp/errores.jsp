<%-- 
    Document   : errores
    Created on : 26 nov 2024, 21:47:55
    Author     : paulvazquez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Errores</title>
    </head>
    <body>
    <center>
        <table width="500px">
            <tr bgcolor="lightgray">
                <th>ERROR de LogIn</th>
            </tr>
        <%
            String msg=(String) request.getAttribute("msg");
            out.println("<tr align='center'>");
            out.println("<td>"+msg+"</td");
            out.println("</tr>");
        %>
        </table>
        <br/>
        <<a href="login.jsp">Volver a LogIn</a>
    </center>
        
        
        
    </body>
</html>