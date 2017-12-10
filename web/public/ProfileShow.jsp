<%-- 
    Document   : ProfileShow.jsp
    Created on : 06.11.2017, 21:17:38
    Author     : Yerke
--%>

<%@page import="Comment_model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Comment_model.Comments"%>
<%@page import="default_settings.Paths"%>
<%@page import="Profile_model.Profile"%>
<%@page import="Profile_model.Profiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/SimpleTag.tld" prefix="SimpleTag"%>
<!DOCTYPE html>
<html>
    <%
        Profiles profilesController = new Profiles();
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        Profile profile = (Profile)profilesController.getItem(idInt);
        

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

        String imgDefined = img[ (int)Math.round(Math.random()*(img.length-1 ))];

    %>
       
<head>
    
    <style>
        .activeBtn{
            background: #FF5A5F;
            color:white;
        }
        .defaultBtn{
            background:white;
            color: #FF5A5F;
        }
    </style>
    
      <jsp:include page = "../Parent.jsp" />
        <link rel="stylesheet" href="../css/ShortProfile.css">
        <link rel="stylesheet" href="../css/ProfileShow.css">
        <script>
        $(document).ready(function() {
            $(".btn-pref .btn").click(function () {
                $(".btn-pref .btn").removeClass("activeBtn").addClass("defaultBtn");
                $(this).removeClass("defaultBtn").addClass("activeBtn");   
            });
        });
        </script>
        
        
        
        <jsp:include page="../includes/HeaderAuth.jsp" /> 
    </head>
    <body>
        
        <div class="panel panel-default col-md-8 col-md-offset-2">

                <div class="card hovercard">
                    <div class="card-background">
                        <img class="card-bkimg" alt="" src=<%= imgDefined %>>
                        <!-- http://lorempixel.com/850/280/people/9/ -->
                    </div>
                    <div class="useravatar" >
                        <img alt="" src=${ imgDefined }>
                    </div>
                    <div class="card-info"> <span class="card-title"><%= profile.getUser().getName()+" "+
                                                                    profile.getUser().getSurname() %></span>

                    </div>
                </div>
            
            

    <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button"  class="btn activeBtn" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <div class="hidden-xs">Profile</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn defaultBtn" href="#tab2" data-toggle="tab"><span class="glyphicon glyphicon-facetime-video"></span>
                <div class="hidden-xs">Videos</div>
            </button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn defaultBtn" href="#tab3" data-toggle="tab"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
                <div class="hidden-xs">Comments</div>
            </button>
        </div>
    </div>
                

                <div class="well">
                  <div class="tab-content">
                    <div class="tab-pane fade in active" id="tab1">
                    <a href=<%=Paths.ROOT_PATH+"OrderServlet?userId="+profile.getUser().getId() %> class="btn offerDeal" id="btn_default">Order</a>
                        <h4><b>Service:</b> <%= profile.getService().getType() %> </h4>
                        <h4><b>Tell Number:</b> <%= profile.getUser().getTellnumber() %></h4>
                        <h4><b>Price:</b> <%= profile.getPrice() %>KZT</h4>
                        <h4><b>City:</b> <%= profile.getCity() %></h4>
                        <h4><b>Description:</b> <%= profile.getDescription() %></h4>
                    </div>
                      
                      
                      
                    <div class="tab-pane fade in" id="tab2">
                        <div class="row">

                            <div class='col-md-4' style='padding-bottom: 30px'>
                                <iframe src="https://www.youtube.com/embed/I4SXG1VazC4" frameborder='0' allowfullscreen style='width: 100%' height="230"></iframe>
                            </div>
                            
                            <div class='col-md-4' style='padding-bottom: 30px'>
                                <iframe src="https://www.youtube.com/embed/a6STeQgzrZw" frameborder='0' allowfullscreen style='width: 100%' height="230"></iframe>
                            </div>

                            <div class='col-md-4' style='padding-bottom: 30px'>
                                <iframe src="https://www.youtube.com/embed/A8SpBNk4X74" frameborder='0' allowfullscreen style='width: 100%' height="230"></iframe>
                            </div>
                            
                            
                        </div>
                    </div>
                      
                      
                      
                    <div class="tab-pane fade in" id="tab3">
                        <form action=<%= Paths.ROOT_PATH+"CommentServlet" %> method="post">
                            <div class="form-group">
                                <p>
                                    Date: <SimpleTag:DisplayDate/>
                                </p>
                              <label for="">Comment:</label>
                              <textarea type="text" class="form-control" placeholder="Comment..." name="content"></textarea>
                            </div>
                            <input type="hidden" name="profile_id" value=<%=profile.getId()%> />
                            <button type="submit" class="btn btn-success">Submit</button>
                        </form>
                        
                        <%
                            Comments commentsController = new Comments();
                            ArrayList<Comment> comments = commentsController.getItemsByProfile(profile.getId());
                            for(int i=0; i<comments.size(); i++){
                        %>
                        
                        <hr/>
                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <%= comments.get(i).getFromUser().getName()+" "+comments.get(i).getFromUser().getSurname()%>
                            </div>
                            <div class="panel-body" >
                                <%= comments.get(i).getContent() %>
                            </div>
                        </div>
                        
                        <%
                            }
                        %>

                        
                    </div>
                  </div>
                </div>

            
        </div>
    </body>

</html>
