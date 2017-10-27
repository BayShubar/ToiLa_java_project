<%-- 
    Document   : Home
    Created on : 26.10.2017, 21:41:36
    Author     : Yerke
--%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user =(User)session.getAttribute("auth");
        if(user == null){
            response.sendRedirect("auth/Home.jsp");
        }
    %>
    <head>
        <jsp:include page = "Parent.jsp" />
    </head>
    <body>
        <jsp:include page="includes/HeaderAuth.jsp" />  
    </body>
</html>
