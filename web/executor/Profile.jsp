<%-- 
    Document   : Profile
    Created on : 01.11.2017, 22:49:44
    Author     : Yerke
--%>

<%@page import="Profile_model.Profile"%>
<%@page import="Profile_model.Profiles"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Service_model.*"%>
<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        // ONLY EXECUTOR HAVE ACCESS TO THIS PAGE
        User user =(User)session.getAttribute("auth");
        if(user == null ){
            response.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
        }else if(!user.getRole().equals("executor")){
            response.sendRedirect(Paths.ROOT_PATH+"Home.jsp");
        }else{
    %>
    
    
    <head>
        <jsp:include page = "../Parent.jsp" />
        <jsp:include page="../includes/HeaderAuth.jsp" /> 
    </head>
    <body>
       <%
           Services servicesController = new Services();
           ArrayList<Service> services = (ArrayList<Service>)servicesController.getItems();
       %>
        <div class="panel panel-default col-md-8 col-md-offset-2">
            
            
            
            
            
           <%
               Profiles profileController = new Profiles();
                if(!profileController.isExist(user.getId())){
           %>
           
           
            <div class="panel-heading"  id="holderHead">
                Create My Profile
            </div>
            <div class="panel-body" >
                
                <form action=<%= Paths.ROOT_PATH + "ProfileServlet" %> method="post">
                    <input type="hidden" name="request_type" value="create"/>
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control" id="price" placeholder="Price..." name="price">
                  </div>
                    
                  <div class="form-group">
                    <label for="">City</label>
                    <input type="text" class="form-control" id="city" placeholder="City.." name="city">
                  </div>
                    
                  <div class="form-group">
                    <label for="">Description</label>
                    <input type="text" class="form-control" id="description" placeholder="Description..." name="description">
                  </div>
                    
                  <div class="form-group">
                    <label>Service type</label>
                        <select class="form-control" id="service" name="service">
                          <%    
                              for(int i = 0; i < services.size();i++){
                          %>
                          <option value=<%= services.get(i).getId() %> > <%= services.get(i).getType()  %></option>
                          <%
                              }
                          %>
                        </select>
                  </div>

                  <button type="submit" class="btn btn-success pull-right">Submit</button>
                </form>
                
            </div>
                        
                        
                        
                        
                        
            <%
                } //ABOVE SHOWN CASE WHEN USER HAVE NOT CREATE PROFILE YET
                else{
                Profile myProfile = (Profile)profileController.getItemByUser(user.getId());
            %>          
                
            
          <div class="panel-heading" id="holderHead">
                Updata my Profile
            </div>
            <div class="panel-body" >
                
                 <form action=<%= Paths.ROOT_PATH + "ProfileServlet" %> method="post">
                  <input type="hidden" name="request_type" value="update"/>
                    
                  <div class="form-group">
                    <label for="price">Price</label>
                    <input type="number" value=<%= myProfile.getPrice() %> class="form-control" id="price" placeholder="Price..." name="price">
                  </div>
                    
                  <div class="form-group">
                    <label for="">City</label>
                    <input type="text" value=<%= myProfile.getCity()%> class="form-control" id="city" placeholder="City.." name="city">
                  </div>
                    
                  <div class="form-group">
                    <label for="">Description</label>
                    <input type="text" value="<%= myProfile.getDescription()%>" class="form-control" id="description" 
                                                                        placeholder="Description..." name="description">
                  </div>
                    
                  <div class="form-group">
                    <label>Service type: <%= myProfile.getService().getType().toUpperCase() %></label>
                        <select class="form-control" id="service" name="service">
                          <%    
                              for(int i = 0; i < services.size();i++){
                          %>
                          <option value=<%= services.get(i).getId() %> > <%= services.get(i).getType() %> </option>
                          <%
                              }
                          %>
                        </select>
                  </div>

                  <button type="submit" class="btn pull-right" id="btn_default">UPDATE</button>
                  
                </form>
                
            </div>
            
            
            
            <%
                } //ABOVE SHOWN CASE WHEN USER HAVE PROFILE AND HERE USER CAN EASILY UPDATE DATA
            %>         
                    
            
            
            
            
        </div>      
    </body>
        
    </body>
    
    
<%}%>
</html>
