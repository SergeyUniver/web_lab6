package managed_beans.pages;

import dao.DAOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Serug on 01.06.2017.
 */
@ManagedBean(name = "make_order", eager = true)
@RequestScoped
public class MakeOrderPage extends BasePage {

    private int dishId;
    private int count;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String makeOrder(){
        try {
            sessionBean.getOrderDAO().makeOrder(dishId, count, true, false, sessionBean.getDishDAO(), sessionBean.getClientDAO());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
