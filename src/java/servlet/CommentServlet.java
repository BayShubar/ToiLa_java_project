package servlet;

import Comment_model.Comment;
import Comment_model.Comments;
import Profile_model.Profile;
import Profile_model.Profiles;
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
public class CommentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getParameter("profile_id") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Comments c = new Comments();
      Profiles p= new Profiles();
      Profile pr = new Profile();
        try {
            pr = (Profile)p.getItem(Integer.parseInt(request.getParameter("profile_id")));
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
      HttpSession session = request.getSession();
      User sent_comment_person = (User)session.getAttribute("auth");
      
      Comment co = new Comment(-1, pr,sent_comment_person,(String)request.getAttribute("test") );
      c.setItem(co);
      
      response.sendRedirect(Paths.ROOT_PATH+"public/ProfileShow.jsp?id="+co.getToProfile().getId());
    }

}
