package managed_beans.pages;

import dao.DAOException;
import entities.Dish;
import entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionas on 01.06.2017.
 */
@ManagedBean(name = "menu", eager = true)
@RequestScoped
public class MenuPage extends BasePage{

    public static int selectedDishId;

    public List<Dish> getMenu() {
        try {
            return sessionBean.getDishDAO().getAllDishes();
        } catch (DAOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public String changeMenu(int dishId) {
        if(sessionBean.getUser().getType().equals(User.ADMIN_TYPE)) {
            selectedDishId = dishId;
            return "edit_menu";
        }else{
            return "menu";
        }
    }
}
