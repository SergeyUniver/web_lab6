package managed_beans.pages;

import dao.DAOException;
import entities.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionas on 01.06.2017.
 */
@ManagedBean(name = "client_orders", eager = true)
@RequestScoped
public class ClientOrdersPage extends BasePage{

    public List<Order> getOrders(){
        try {
            return sessionBean.getOrderDAO().showOrdersByClient(1);
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
