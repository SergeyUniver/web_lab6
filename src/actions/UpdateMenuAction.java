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
 * Created by Serug on 01.06.2017.
 */
public class UpdateMenuAction extends Action implements IAction {
    public UpdateMenuAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cost = Integer.parseInt(request.getParameter(EditMenuAction.DISH_COST_PARAM));
        String name = request.getParameter(EditMenuAction.DISH_NAME_PARAM);
        int id = EditMenuAction.lastDishId;
        daoCreator.getDishDAO().updateDishById(id, name, cost);
        new ShowMenuAction(daoCreator).execute(request, response);
    }
}
