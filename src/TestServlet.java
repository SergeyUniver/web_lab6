import action.Action;
import action.ActionManager;
import dao.*;
import entities.Order;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Serug on 21.05.2017.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet implements DAOCreator {

    @EJB
    private DishDAO dishDAO;
    @EJB
    private ClientDAO clientDAO;
    @EJB
    private OrderDAO orderDAO;
    @EJB
    private UserDAO userDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionManager.getAction(request, this).execute(request, response);    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionManager.getAction(request, this).execute(request, response);
    }

    @Override
    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    @Override
    public DishDAO getDishDAO() {
        return dishDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    @Override
    public UserDAO getUserDAO() {
        return userDAO;
    }
}
