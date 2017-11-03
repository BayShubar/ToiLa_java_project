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
        <link rel="stylesheet" href="css/ShortProfile.css">
        
        
        <jsp:include page = "Parent.jsp" />
        <jsp:include page="includes/HeaderAuth.jsp" /> 
    </head>
    <body>
        <div class="panel panel-default col-md-12 col-md-offset-0">
            <div class="panel-heading"  id="holderHead">
                Services
            </div>
            <div class="panel-body" >
                <div class="container">
                    <div class="row">
                
                <%
                Profiles profilesController = new Profiles();
                ArrayList<Profile> profiles = new ArrayList();
                profiles = (ArrayList<Profile>)profilesController.getItems();
                
                for(int i=0; i<profiles.size(); i++){
                %>
                
                
                                        

                <div class="col-md-4">
                    <div class="profile-item">
                      <div class="pi-img-wrapper">
                        <img src="http://iartist.kz/wp-content/uploads/2016/06/1-28.jpg" class="img-responsive">
                      </div>
                      <h3><a href="#"><%= profiles.get(i).getUser().getName() +" "+ 
                                    profiles.get(i).getUser().getSurname() %></a></h3>
                      <h5><%= profiles.get(i).getDescription() %></h5>
                      <div class="pi-price"><%= profiles.get(i).getPrice() %>KZT</div>
                      <a href="javascript:;" class="btn offerDeal" id="btn_default">Order</a>
        <!--              <div class="sticker sticker-new"></div>-->
                    </div>
                </div>
    
                         
                         
                
                <%}%>
                </div>
            </div>     
                
            </div>
        </div>
    </body>

    
  <%}%>
</html>
