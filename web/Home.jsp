<%-- 
    Document   : Home
    Created on : 26.10.2017, 21:41:36
    Author     : Yerke
--%>
<%@page import="Profile_model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user =(User)session.getAttribute("auth");
        if(user == null){
            response.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
        }else{
    %>
    
    
    
    <head>
        <jsp:include page = "Parent.jsp" />
        <jsp:include page="includes/HeaderAuth.jsp" /> 
    </head>
    <body>
        <div class="panel panel-default col-md-8 col-md-offset-2">
            <div class="panel-heading">
                Services
            </div>
            <div class="panel-body" >
                
                
                <%
                Profiles profilesController = new Profiles();
                ArrayList<Profile> profiles = new ArrayList();
                profiles = (ArrayList<Profile>)profilesController.getItems();
                
                for(int i=0; i<profiles.size(); i++){
                %>
                
                
                
                <div class="panel panel-info col-md-4" style="margin-right: 0px;">
                    <div class="panel-heading">
                       <%= profiles.get(i).getUser().getName() +" "+ profiles.get(i).getUser().getSurname() %>
                    </div>
                    <div class="panel-body">
                        <h5><b>City: </b><%= profiles.get(i).getCity() %></h5>
                        <h5><b>price: </b><%= profiles.get(i).getPrice() %>KZT</h5>
                        <h5><b>Service: </b></b><%= profiles.get(i).getService().getType() %></h5>
                        <h5><b>Description: </b><%= profiles.get(i).getDescription() %></h5>  
                        <hr/>
                         <h5><b>contact: </b><%= profiles.get(i).getUser().getTellnumber() %></h5>
                         <hr/>
                         <button class="btn btn-success pull-right">Order a Call</button>
                    </div>
                </div>
                         
                         
                         
                         
                
                <%}%>
                
            </div>
        </div>
    </body>

    
  <%}%>
</html>
