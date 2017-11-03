<%-- 
    Document   : Signup.jsp
    Created on : 26.10.2017, 11:42:32
    Author     : Yerke
--%>

<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user =(User)session.getAttribute("auth");
        if(user != null){
            RequestDispatcher rd = request.getRequestDispatcher("../Home.jsp");
            rd.forward(request, response);
        }
    %>
    <head>
        <jsp:include page = "../Parent.jsp" />
    </head>
    <body>
        <jsp:include page= "../includes/Header.jsp" />
        <br>
        <div class="panel panel-success  col-md-4 col-md-offset-4">
            <div class="panel-heading">
                Registration
                <a href="Login.jsp" class="btn btn-success pull-right btn-xs">Login</a>
            </div>
            <div class="panel-body">
                
                
                <form   action=<%=Paths.ROOT_PATH + "AuthServlet"%>    method="post">
                  <input type="hidden" name="type" value="registr"/>
                  
                  <div class="form-group">
                    <label for="email">Tell number:</label>
                    <input type="text" class="form-control" id="email" placeholder="Tell Number..." name="tellnumber">
                  </div>
                  
                  <div class="form-group">
                    <label for="email">Name:</label>
                    <input type="text" class="form-control" id="email" placeholder="Name..." name="name">
                  </div>
                  
                  <div class="form-group">
                    <label for="email">Surname:</label>
                    <input type="text" class="form-control" id="email" placeholder="Surname..." name="surname">
                  </div>
                  
                  <div class="form-group">
                    <label>Role</label>
                        <select class="form-control" id="sel1" name="role">
                          <option value="executor">Executor</option>
                          <option value="client">Client</option>
                        </select>
                  </div>
                                    
                  <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="text" class="form-control" id="pwd" placeholder="Enter password" name="password">
                  </div>
                                    
                  <button type="submit" class="btn btn-success">Submit</button>
                </form>
                
                
            </div>
        </div>
    </body>
</html>
