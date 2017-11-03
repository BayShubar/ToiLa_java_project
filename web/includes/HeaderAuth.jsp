<%-- 
    Document   : HeaderAuth.jsp
    Created on : 27.10.2017, 16:15:58
    Author     : Yerke
--%>

<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user =(User)session.getAttribute("auth");
        if(user == null){
            response.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
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
              <li class="active"><a      href=<%=Paths.ROOT_PATH+"Home.jsp"%>    ><span class="glyphicon glyphicon-home"></span> Home</a></li>
              <li><a href="#"><span class="glyphicon glyphicon-search"></span> Search</a></li>
              
              <% if(user.getRole().equals("executor")){ %>
                <li><a  href=<%=Paths.ROOT_PATH+"executor/Profile.jsp"%>     ><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                <li><a href="#">Prefer Hire You <span class="badge">5</span></a></li>
                <li><a href="#">Offer Services <span class="badge">3</span></a></li>
              <%}else if( user.getRole().equals("client") ){%>
                <li><a href="#">Offers Condition <span class="badge">3</span></a></li>
              <%}%>
              
              
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a><%= user.getName() %></a> </li>
              <li><a     href=<%=Paths.ROOT_PATH+"AuthServlet"%>   ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
          </div>
        </nav>
    </body>
</html>
