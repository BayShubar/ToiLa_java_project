package servlet;

import Orders_model.*;
import User_model.*;
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
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int id = (int)Integer.parseInt(request.getParameter("userId"));
            Users usersController = new Users();
        try {
            User userToSend = usersController.getItem(id);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(Paths.ROOT_PATH+"authenticated/Order.jsp?userId="+id);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         User auth_user = (User)session.getAttribute("auth");
         
         String TYPE = request.getParameter("type");

         if(auth_user == null){
            response.sendRedirect(Paths.ROOT_PATH+"Login.jsp");
         }else if(auth_user != null){
             if( TYPE.equals("create") ){
                createOrder(request, response, auth_user);
                response.sendRedirect(Paths.ROOT_PATH+"Home.jsp");
             }else if( TYPE.equals("accept") ){
                 
                 try {
                     acceptOrder(request, response, auth_user);
                 } catch (NoSuchFieldException ex) {
                     Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 response.sendRedirect(Paths.ROOT_PATH+"authenticated/Offers.jsp");
                 
             }else if( TYPE.equals("delete") ){
                 response.sendRedirect(Paths.ROOT_PATH+"authenticated/Offers.jsp?HERE_YOU_HAVE_PROBLEM="+request.getParameter("orderId"));
             }else{
                 // Future use
             }
 
         }
    }
    
    
    private void deleteOrder( HttpServletRequest request, HttpServletResponse response, User auth_user ) 
            throws NoSuchFieldException{
         String id = request.getParameter("orderId");
         Orders ordersController = new Orders();
         ordersController.setStatus(id);
    }
    
    private void acceptOrder( HttpServletRequest request, HttpServletResponse response, User auth_user ) 
            throws NoSuchFieldException{
         String id = request.getParameter("orderId");
         Orders ordersController = new Orders();
         ordersController.setStatus(id);
    }
    
    private void createOrder(HttpServletRequest request, HttpServletResponse response, User auth_user)
            throws ServletException, IOException {
                     int userToSend = (int)Integer.parseInt(request.getParameter("userToSend"));
             String date = request.getParameter("date");
             String message = request.getParameter("message");
             
            Orders ordersController = new Orders();
            Order order = null;
            
                try {
                   order = new Order(
                            -1,
                            auth_user.getId(),
                            userToSend,
                            date,
                            message
                    );
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

             ordersController.setItem(order);
    }
    
    
}
