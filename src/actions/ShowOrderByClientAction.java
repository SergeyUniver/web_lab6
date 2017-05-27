package actions;

import action.Action;
import action.IAction;
import dao.DAOCreator;
import dao.DAOException;
import dao.OrderDAO;
import entities.Order;

import javax.ejb.EJB;
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
public class ShowOrderByClientAction extends Action implements IAction {

    @EJB
    private OrderDAO orderDAO;

    public static final String CLIENT_ID_PARAM = "client_id";
    public static final String ORDERS_PARAM = "orders";

    public ShowOrderByClientAction(DAOCreator daoCreator) {
        super(daoCreator);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter(CLIENT_ID_PARAM));

        List<Order> orders = new ArrayList<>();
        try {
            orders = daoCreator.getOrderDAO().showOrdersByClient(clientId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("client_id", clientId);
        session.setAttribute("orders", orders);
        session.setAttribute(SESSION_PARAM, SessionHelper.createSession(request));
        response.sendRedirect("orders.jsp");
    }
}
