package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;
import dao.DAOException;
import entities.User;

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
public class SignUpAction extends Action implements IAction {

    public static final String MESSAGE_PARAM = "message";

    public SignUpAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User user = daoCreator.getUserDAO().createNewUser(login, password);
            if (user == null) {
                HttpSession session = request.getSession();
                session.setAttribute(MESSAGE_PARAM, "User already exist");
                response.sendRedirect("sign_up.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute(SessionHelper.USER_ATTR, user);
                Cookie userInf = new Cookie("lastGet", new Date().toLocaleString());
                response.addCookie(userInf);
                response.sendRedirect("index.jsp");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
