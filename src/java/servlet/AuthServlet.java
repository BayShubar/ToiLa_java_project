package servlet;

import User_model.User;
import User_model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yerke
 */
public class AuthServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("auth", null);
        response.sendRedirect("auth/Login.jsp");
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String requestType = (String)request.getParameter("type");
       
       if(requestType.equals("login")){
           loginHandler(request, response);
       }else if(requestType.equals("registr")){
           registrHandler(request, response);
       }else{
           //error
       }
       
    }
    
    
    
    private void loginHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users users = new Users();
        
        String tellNumber = request.getParameter("tellnumber");
        String password = request.getParameter("password");
        
        if(users.auth(tellNumber, password)){
            User user = users.getUserByTellNumber(tellNumber);
            setSession(request, user);
            response.sendRedirect("Home.jsp");
//            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
//            rd.forward(request, response);
        }
        else {
            response.sendRedirect("auth/Login.jsp");
        }
    }
    
    
     private void registrHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String tellnumber = request.getParameter("tellnumber");
         String name = request.getParameter("name");
         String surname = request.getParameter("surname");
         String role = request.getParameter("role");
         String password = request.getParameter("password");
         
         Users users = new Users();
                  
         if(users.sameTellNumber(tellnumber)){
             response.sendRedirect("auth/Registr.jsp");
         }else if(!(password.length() > 3)){
             response.sendRedirect("auth/Registr.jsp");
         }else if(name.length() == 0 || surname.length() == 0){
             response.sendRedirect("auth/Registr.jsp");
         }else{
             User user = new User( -1, tellnumber, name, surname, role, password);
             users.setItem(user);
             
            user = users.getUserByTellNumber(tellnumber);
            setSession(request, user);
             response.sendRedirect("Home.jsp");
         }       
    }
     
    
     private void setSession(HttpServletRequest request, User user){
         HttpSession session = request.getSession();
         session.setAttribute("auth", user);
     }
    
}
