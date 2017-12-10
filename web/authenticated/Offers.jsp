<%-- 
    Document   : Offers.jsp
    Created on : 07.11.2017, 4:13:50
    Author     : Yerke
--%>

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
        ArrayList<Order> orders = orderController.getOffers(user.getId()) ; 
    %>
    
        <head>
         <jsp:include page = "../Parent.jsp" />
         <jsp:include page="../includes/HeaderAuth.jsp" /> 
        </head>
        <body>
        <div class="panel panel-default col-md-6 col-md-offset-3">
            <div class="panel-heading"  id="holderHead">
                Offers
            </div>
            <div class="panel-body" >
                
            <% for(int i=0; i<orders.size(); i++){ %>
              <div class="container col-md-12" style="margin-bottom: 20px; border: 1px solid #FF5A5F;   
                   padding:15px 10px 10px 10px; border-radius: 10px;" >
                    <div class="row">
                        
                        <div class="col-md-3">
                            <b style="margin-bottom: -20px; color:#FF5A5F;"><%= (orders.get(i).getClient().getName()+" "+orders.get(i).getClient().getSurname()).toUpperCase() %></b>
                            <p style="font-size: 12px;"><br><%= orders.get(i).getDate() %></p>
                        </div>
                        <div class="col-md-6">
                            <%= orders.get(i).getMessage() %>
                        </div>
                        
                        <div class="col-md-3">
                           <div class="pull-right">
                            <%
                                if(orders.get(i).getStatus().equals("true")){ //IF OFFER ACCEPTED 
                            %>
                               <p style='color: green; display: inline-block; padding:1px 5px; border: solid green 1px; border-radius: 5px;'
                                >Accepted</p>
                            <%
                                }else{ //IF OFFER DO NOT ACCEPTED
                            %>

                                <form action=<%= Paths.ROOT_PATH + "OrderServlet" %> method="post" id='formAccept'>
                                     <input type="hidden" name="type" value="accept" >
                                     <input type="hidden" name="orderId" value=<%= orders.get(i).getId() %> >
                                    <button type="submit" form="formAccept" class="btn btn-success btn-xs">    
                                                <span class="glyphicon glyphicon-ok"></span></button>
                                 </form>
                                                
                            <%
                                }
                            %>
                             <button type="submit" form="formDelete" class="btn btn-danger btn-xs">
                                     <span class="glyphicon glyphicon-remove"></span></button>
                            <form action=<%= Paths.ROOT_PATH + "OrderServlet" %> method="post" id='formDelete'>
                                     <input type="hidden" name="type" value="delete" >
                                     <input type="hidden" name="orderId" value='<%= orders.get(i).getId() %>' >
                            </form>
                           </div>
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
