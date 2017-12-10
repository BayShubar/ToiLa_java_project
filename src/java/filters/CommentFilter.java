/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import User_model.User;
import User_model.Users;
import default_settings.Paths;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yerke
 */
public class CommentFilter implements Filter {
    
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;
    
    public CommentFilter() {
    }    
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        User u = ( User )req.getSession().getAttribute("auth");
        if(u != null){
            Users userController = new Users();
            String content = (String) request.getParameter("content");
            String  time = new SimpleDateFormat("dd/MM/yyyy-HH:mm").format(Calendar.getInstance().getTime());
            content="( "+time+" ) "+content ;        
            request.setAttribute("test", content);
            chain.doFilter(request, response);
        }else
            res.sendRedirect(Paths.ROOT_PATH+"auth/Login.jsp");
    }

    
    
    
    
    
    
    public void destroy() {        
    }
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("CommentFilter:Initializing filter");
            }
        }
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
