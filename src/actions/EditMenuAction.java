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

/**
 * Created by Ionas on 01.06.2017.
 */
public class EditMenuAction extends Action implements IAction {
    public static final String DISH_ID_PARAM = "dish_id";
    public static final String DISH_NAME_PARAM = "dish_name";
    public static final String DISH_COST_PARAM = "dish_cost";

    public static int lastDishId;

    public EditMenuAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dishId = Integer.parseInt(request.getParameter(DISH_ID_PARAM));
        try {
            Dish dish = daoCreator.getDishDAO().getDishById(dishId);
            HttpSession session = request.getSession();
            session.setAttribute(DISH_NAME_PARAM, dish.getName());
            session.setAttribute(DISH_COST_PARAM, dish.getCost());
            lastDishId = dishId;
            response.sendRedirect("edit_menu.jsp");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
