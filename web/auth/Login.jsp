<%-- 
    Document   : Login.jsp
    Created on : 26.10.2017, 11:41:56
    Author     : Yerke
--%>

<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.DBUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        User user =(User)session.getAttribute("auth");
        if(user != null){
             response.sendRedirect("../Home.jsp");
        }
    %>
    
    <head>
      <jsp:include page = "../Parent.jsp" />
    </head>
    <body>
        <jsp:include page= "../includes/HeaderAuth.jsp" />
        <br>
        <div class="panel panel-success  col-md-4 col-md-offset-4">
            <div class="panel-heading">
                Login
                <a href="Registr.jsp" class="btn btn-success pull-right btn-xs">Registration</a>
            </div>
            <div class="panel-body">
                <form   action=<%=Paths.ROOT_PATH + "AuthServlet"%>  method="post">
                  <input type="hidden" name="type" value="login"/>
                  <div class="form-group">
                    <label for="email">Tell number:</label>
                    <input type="text" class="form-control" id="email" placeholder="Tell Number..." name="tellnumber">
                  </div>
                  <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                  </div>
                  <button type="submit" class="btn btn-success">Submit</button>
                </form>
            </div>
        </div>
        
    </body>
</html>
