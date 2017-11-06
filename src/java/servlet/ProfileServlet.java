package servlet;

import Profile_model.Profile;
import Profile_model.Profiles;
import Service_model.Service;
import User_model.User;
import default_settings.Paths;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yerke
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        response.sendRedirect(Paths.ROOT_PATH+"public/ProfileShow.jsp?id="+id);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("request_type").equals("create")){
             profileCreate(request, response);
         }else if(request.getParameter("request_type").equals("update")){
             
             
             try {
                 ProfileUpdate(request, response);
             } catch (NoSuchFieldException ex) {
                 Logger.getLogger(ProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
         }else{
             //errror
         }
    }

    protected void ProfileUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchFieldException {
                if(isFilled(request)){
           Profiles profileController = new Profiles();      
              
           HttpSession session = request.getSession();
           User user = (User)session.getAttribute("auth");
           
           String services_id = request.getParameter("service"),
                  price = request.getParameter("price"),
                  city = request.getParameter("city"),
                  description = request.getParameter("description");
           
           Profile profile = new Profile(
                   0,
                   user,
                   new Service(Integer.parseInt(services_id)),
                   price, 
                   city,
                   description
           );
           
          profileController.updateItem(profile);
          response.sendRedirect(Paths.ROOT_PATH+"executor/Profile.jsp");
          
        }else{
           response.sendRedirect(Paths.ROOT_PATH+"executor/Profile.jsp");
        }
    }
    
    
    protected void profileCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isFilled(request)){
           HttpSession session = request.getSession();
           User user = (User)session.getAttribute("auth");
           
           String services_id = request.getParameter("service"),
                  price = request.getParameter("price"),
                  city = request.getParameter("city"),
                  description = request.getParameter("description");
           
           Profile profile = new Profile(
                   -1,
                   user,
                   new Service(Integer.parseInt(services_id)),
                   price, 
                   city,
                   description
           );
           
           Profiles profileController = new Profiles();
           profileController.setItem(profile);
          response.sendRedirect(Paths.ROOT_PATH+"executor/Profile.jsp");
        }else{
           response.sendRedirect(Paths.ROOT_PATH+"executor/Profile.jsp");
        }
    }
    
    protected boolean isFilled(HttpServletRequest request)
            throws ServletException, IOException {
        if(request.getParameter("price").equals("") || request.getParameter("city").equals("") || 
                request.getParameter("description").equals("") || request.getParameter("service").equals(""))
            return false;
         return true;
    }
    

}
