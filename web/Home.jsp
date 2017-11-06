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
            
        String[] img =new String[]{
            "https://pmcdeadline2.files.wordpress.com/2017/03/leonardo-dicaprio.jpg?w=605",
            "http://v.img.com.ua/b/1100x999999/0/50/4ea6b47235e230ca32ce38bb384b4500.jpg",
            "http://static6.businessinsider.com/image/52b093d669bedd84559b44c9-1200/mark-wahlberg.png",
            "http://www.worldblaze.in/wp-content/uploads/2014/12/Sonam-Kapoor.jpg",
            "http://www.worldstopmost.com/wp-content/uploads/2016/08/Kristen-Stewart-top-Hollywood-actresses-2016-2017-2018.jpg",
            "http://img.xcitefun.net/users/2008/09/10853,xcitefun-camilla-belle-6.jpg",
            "https://img.tyt.by/720x720s/n/afisha/0d/e/chudo_zhenshchina_1.jpg",
            "https://www.mirf.ru/wp-content/uploads/2017/10/thor-ragnarok-photo-Chris-Hemsworth.jpg",
        };


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
                

                    <div class="col-md-4" style="height: 410px;">
                        <div class="profile-item">
                          <div class="pi-img-wrapper">
                              <img src=<%= img[ (int)Math.round(Math.random()*(img.length-1 ))] %> 
                                   style="height:250px;" class="img-responsive">
                          </div>
                          <h3><a href=<%=Paths.ROOT_PATH+"ProfileServlet?id="+profiles.get(i).getId()  %>><%= profiles.get(i).getUser().getName() +" "+ 
                                        profiles.get(i).getUser().getSurname() %></a></h3>
                          <h5><%= profiles.get(i).getDescription() %></h5>
                          <div class="pi-price"><%= profiles.get(i).getPrice() %>KZT</div>
                          <a href=<%=Paths.ROOT_PATH+"OrderServlet?userId="+profiles.get(i).getUser().getId() %> class="btn offerDeal" id="btn_default">Order</a>
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
