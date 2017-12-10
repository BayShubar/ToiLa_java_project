<%-- 
    Document   : Order
    Created on : 07.11.2017, 1:47:41
    Author     : Yerke
--%>

<%@page import="default_settings.Paths"%>
<%@page import="User_model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        //AUTHENTICATED ONLY BOTH EXECUTOR AND CLIENT
        User user =(User)session.getAttribute("auth");
        if(user == null ){
            response.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
        }else{
    %>
    
    
    <head>
     <jsp:include page = "../Parent.jsp" />
     <jsp:include page="../includes/HeaderAuth.jsp" /> 
    </head>
    
    <%
        int id = (int)Integer.parseInt(request.getParameter("userId"));
        Users usersController = new Users();
        User userToSend = usersController.getItem(id);

    %>
    
    <body>
        
        <div class="panel panel-default col-md-6 col-md-offset-3">          
            <div class="panel-heading"  id="holderHead">
                Create My Profile
            </div>
            <div class="panel-body" >
                
                
               <form action=<%= Paths.ROOT_PATH + "OrderServlet" %> method="post">
                    <input type="hidden" name="type" value="create" >
                    <input type="hidden" name="userToSend" value=<%= userToSend.getId() %>>
                  <div class="form-group">
                    <label for="price">Date</label>
                    <input type="date" class="form-control"  name="date">
                  </div>
                  
                  <div class="form-group">
                    <label>Short Message</label>
                    <input type="text" class="form-control" id="price" placeholder="My Message" name="message">
                  </div>
                    
                  <button type="submit" id="btn_default" class="btn btn-success pull-right">SUBMIT</button>
                </form>
                
                
            </div>
        </div>
        
    </body>
    
    
    <%
        }
    %>
</html>
