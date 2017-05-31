package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Serug on 01.06.2017.
 */
public class LogOutAction extends Action implements IAction {
    public LogOutAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionHelper.USER_ATTR, null);
        response.sendRedirect("sign_up.jsp");
    }
}
