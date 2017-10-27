<%-- 
    Document   : HeaderAuth.jsp
    Created on : 27.10.2017, 16:15:58
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
        <jsp:include page = "../Parent.jsp" />
    </head>
    <body>
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">ToiLa</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#">Page 1</a></li>
              <li><a href="#">Page 2</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a><%= user.getName() %></a> </li>
              <li><a href="AuthServlet"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
          </div>
        </nav>
    </body>
</html>
