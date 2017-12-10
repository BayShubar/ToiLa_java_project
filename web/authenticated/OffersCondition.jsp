<%-- 
    Document   : Offers.jsp
    Created on : 07.11.2017, 4:13:50
    Author     : Yerke
--%>

<%@page import="Profile_model.Profile"%>
<%@page import="Profile_model.Profiles"%>
<%@page import="Orders_model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Orders_model.Orders"%>
<%@page import="default_settings.Paths"%>
<%@page import="User_model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        
    <%
        //AUTHENTICATED ONLY BOTH EXECUTOR AND CLIENT
        User user =(User)session.getAttribute("auth");
        if(user == null ){
            response.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
        }else{
            
        Orders orderController = new Orders();
        ArrayList<Order> orders = orderController.getOrders(user.getId()) ; 
    %>
    
        <head>
         <jsp:include page = "../Parent.jsp" />
         <jsp:include page="../includes/HeaderAuth.jsp" /> 
        </head>
        <body>
        <div class="panel panel-default col-md-6 col-md-offset-3">
            <div class="panel-heading"  id="holderHead">
                My Offers Condition
            </div>
            <div class="panel-body" >
                
              <% 
                  Profiles profileController = new Profiles();
                  for(int i=0; i<orders.size(); i++){
                  Profile profile = (Profile)profileController.getItemByUser(orders.get(i).getExecutor().getId());
              %>
              <div class="container col-md-12" style="margin-bottom: 20px; border: 1px solid #FF5A5F;   
                   padding:15px 10px 10px 10px; border-radius: 10px;" >
                    <div class="row">
                        <div class="col-md-3">
                            <a href=<%= Paths.ROOT_PATH + "public/ProfileShow.jsp?id="+profile.getId()   %>>
                                <b style="margin-bottom: -20px; color:#FF5A5F;">
                                    <%= (orders.get(i).getExecutor().getName()+" "
                                    + ""+orders.get(i).getExecutor().getSurname()).toUpperCase() %>
                                </b>
                            </a>
                            <p style="font-size: 12px;"><br><%= orders.get(i).getDate() %></p>
                        </div>
                        <div class="col-md-6">
                            <%= orders.get(i).getMessage() %>
                        </div>
                        <div class="col-md-3">
                            
                            <% 
                                if(orders.get(i).getStatus().equals("true")? true : false ){
                            %>
                                <p style='color: greenyellow; display: inline-block; padding:1px 5px; border: solid greenyellow 1px; border-radius: 5px;'
                                >Accepted</p>
                            <%
                                }else{
                            %>
                               <p style='color: red; display: inline-block; padding:1px 5px; border: solid red 1px; border-radius: 5px;'
                                > NotAccepted</p>
                            <%
                                }
                            %>
                            
                            <button class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span></button>
                        </div>    
                        
                    </div>
                </div>
             <%
                }
             %> 
                
            </div>
        </div>
        </body>
    
    <%
        }
    %>
</html>
