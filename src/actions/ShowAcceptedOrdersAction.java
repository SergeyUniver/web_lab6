package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;
import dao.DAOException;
import entities.Dish;
import entities.Order;

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
public class ShowAcceptedOrdersAction extends Action implements IAction {
    public static final String ORDER_PARAM = "orders";

    public ShowAcceptedOrdersAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList<>();
        try {
            orders = daoCreator.getOrderDAO().getAcceptedOrders();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute(ORDER_PARAM, orders);
        response.sendRedirect("accepted_orders.jsp");
    }
}
