package managed_beans.property;

import dao.ClientDAO;
import dao.DishDAO;
import dao.OrderDAO;
import dao.UserDAO;
import entities.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Ionas on 01.06.2017.
 */
@ManagedBean(name = "session_bean", eager = true)
@SessionScoped
public class SessionBean {

    @EJB
    private DishDAO dishDAO;
    @EJB
    private ClientDAO clientDAO;
    @EJB
    private OrderDAO orderDAO;
    @EJB
    private UserDAO userDAO;

    private User user;

    public SessionBean(){

    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAuthorizeUser() {
        return user != null;
    }

    public void clearUser() {
        user = null;
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
