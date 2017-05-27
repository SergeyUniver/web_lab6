package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;
import dao.DAOException;
import entities.Dish;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serug on 21.05.2017.
 */
public class MakeOrderAction extends Action implements IAction {

    public static final String SELECTED_DISH_NAME = "selected_dish";
    public static final String MENU_PARAM = "menu";

    public MakeOrderAction(DAOCreator daoCreator) {
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
        response.sendRedirect("make_order.jsp");
    }
}
