package filters;

import action.ActionManager;
import actions.SessionHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ionas on 31.05.2017.
 */
public class CheckAuth implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        if(action.equals("SIGN_IN") || action.equals("SIGN_UP") || session.getAttribute(SessionHelper.USER_ATTR) != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            HttpServletResponse resp = (HttpServletResponse)servletResponse;
            resp.sendRedirect("sign_up.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
