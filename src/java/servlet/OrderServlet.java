package servlet;

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
        
         int id = (int)Integer.parseInt(request.getParameter("userToSend"));
         response.sendRedirect(Paths.ROOT_PATH+"authenticated/Order.jsp?userId="+id);
    }
}
