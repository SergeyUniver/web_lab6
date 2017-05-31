package tags;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

import entities.User;

public class LoginTag extends BodyTagSupport {
	/**
	 * Logger
	 */
	/**
	 * Construct start of the tag
	 */
	public int doStartTag() throws JspException {
			HttpSession session = pageContext.getSession();
			String action = (String)session.getAttribute("action");
			if (action != null && action.equals("login")) {
				session.setAttribute("action", null);
				User user = (User)session.getAttribute("user");
				if (user == null)
					session.setAttribute("forward", "signup.jsp");
				else session.setAttribute("forward", null);
			}
			else session.setAttribute("forward", null);
		return SKIP_BODY;
	}
	/**
	 * Construct end of the tag
	 */
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
