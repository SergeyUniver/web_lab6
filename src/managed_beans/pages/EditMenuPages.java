package managed_beans.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Serug on 01.06.2017.
 */
@ManagedBean(name = "edit_menu", eager = true)
@RequestScoped
public class EditMenuPages extends BasePage {

    private int dishId;
    private String name;
    private int cost;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String save() {
        sessionBean.getDishDAO().updateDishById(dishId, name, cost);
        return "index";
    }
}
