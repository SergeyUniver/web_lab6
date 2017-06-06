package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;
import dao.DAOException;
import entities.Dish;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionas on 21.05.2017.
 */
public class ShowMenuAction extends Action implements IAction {
    public static final String MENU_PARAM = "menu";
    public static final String IS_ADMIN_PARAM = "is_admin";

    public ShowMenuAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dish> dishes = new ArrayList<>();
        try {
            dishes = daoCreator.getDishDAO().getAllDishes();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute(MENU_PARAM, dishes);
        if(((User)session.getAttribute(SessionHelper.USER_ATTR)).getType().equals(User.ADMIN_TYPE)){
            session.setAttribute(IS_ADMIN_PARAM, true);
        }else{
            session.setAttribute(IS_ADMIN_PARAM, false);
        }
        response.sendRedirect("menu.jsp");
    }
}
