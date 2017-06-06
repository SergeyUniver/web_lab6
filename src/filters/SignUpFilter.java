package filters;

import actions.SessionHelper;
import actions.SignUpAction;

import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ionas on 31.05.2017.
 */
public class SignUpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String action = req.getParameter("action");
        if(action.equals("SIGN_UP")) {
            String login = req.getParameter("login");

            int i;
            for(i = 0; i != login.length(); ++i) {
                char c = login.charAt(i);
                if((c < 97 || c > 122) && (c < 65 || c > 90) && (c < 48 || c > 57) && c != 95) {
                    break;
                }
            }

            if(i == login.length()) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                session.setAttribute(SignUpAction.MESSAGE_PARAM, "Login must contains: (a-z, A-Z), numbers (0-9) or symbols (_)");
                resp.sendRedirect("sign_up.jsp");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
