<%-- 
    Document   : Header.jsp
    Created on : 27.10.2017, 15:15:16
    Author     : Yerke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
              <li><a href="#">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="../auth/Registr.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
              <li><a href="../auth/Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
          </div>
        </nav>

    </body>
</html>
