<%-- 
    Document   : HeaderAuth.jsp
    Created on : 27.10.2017, 16:15:58
    Author     : Yerke
--%>

<%@page import="Bean.Timer"%>
<%@page import="Orders_model.Orders"%>
<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page = "../Parent.jsp" />
    </head>
    <body>
        
    <%
        User user =(User)session.getAttribute("auth");
        if(user == null){    //IF USER UNAUTHORIZED THEN IT OUTPUT FOLLOWING HEADER
    %>
        
               
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">ToiLa</a>
            </div>
            <ul class="nav navbar-nav">
              <li><a href="#">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a    href=<%=Paths.ROOT_PATH+"auth/Registr.jsp"%>   ><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
              <li><a    href=<%=Paths.ROOT_PATH+"auth/Login.jsp"%>     ><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
          </div>
        </nav>
            
            
            
    <%
       }else if(user != null){   // OTHERWISE IT SHOW FOLLOWING OUTPUT
    %>   
    
      <nav class="navbar navbar-inverse" id="navbar_default">
             
       <div class="container-fluid">

            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" 
                      style='background-color: #FF5A5F; border:0px solid red; '>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
              </button>
              <a class="navbar-brand" id="navbar_default_btn" href="#">ToiLa</a>
            </div>
              
              
         <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
             <li><a  id="navbar_default_btn"    href=<%=Paths.ROOT_PATH+"Home.jsp"%>    ><span class="glyphicon glyphicon-home"></span> Home</a></li>
<!--              <li><a  id="navbar_default_btn"    href="#"><span class="glyphicon glyphicon-search"></span> Search</a></li>-->
  
              <% if(user.getRole().equals("executor")){ 
                Orders oredersController = new Orders();
                int offersNum = oredersController.getOrdersNumber(user.getId());
              %>
                
              
              
                <li><a  id="navbar_default_btn" href=<%=Paths.ROOT_PATH+"executor/Profile.jsp"%>     ><span class="glyphicon glyphicon-user"></span> Profile</a></li>
<!--                <li><a  id="navbar_default_btn" href=<%=Paths.ROOT_PATH+"executor/Profile.jsp"%>     ><span class="glyphicon glyphicon-bell"></span> Anouncements </a></li>-->
                <li><a  id="navbar_default_btn" href=<%=Paths.ROOT_PATH+"authenticated/Offers.jsp"%>> Offers <span id="navbar_default" class="badge"><%= offersNum %></span></a></li>
                
<!--                <li><a  id="navbar_default_btn" href="#">Offers Condition<span id="navbar_default" class="badge">3</span></a></li>-->
                
                
                
              <%}else if( user.getRole().equals("client") ){%>
                <li><a  id="navbar_default_btn" href=<%=Paths.ROOT_PATH+"authenticated/OffersCondition.jsp"%>   >Offers Condition <span id="navbar_default" class="badge">4</span></a></li>
              <%}%> 
              
              
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <jsp:useBean id="timer" class="Bean.Timer" />
              <jsp:setProperty name="timer" property="creationTime" value="<%= session.getCreationTime() %>"/>
              <li><a id="navbar_default_btn">LEFT SESSION TIME:
                      <jsp:getProperty name="timer" property="leftTime" />
                 </a> </li>
              <li><a id="navbar_default_btn"><%= user.getName()+" "+user.getSurname() %></a> </li>
              <li><a   id="navbar_default_btn"  href=<%=Paths.ROOT_PATH+"AuthServlet"%>   ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>

          </div>  
        </div>
        </nav>
    
    
    <%
       }
    %>   
       
            
    </body>
</html>
