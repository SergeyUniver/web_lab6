package dao;

import com.sun.istack.internal.Nullable;
import entities.Dish;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Sergey on 20.02.2017.
 */
@Stateless
public class DishDAO extends DAO{

    private static final String SQLRequestGetAllDishes = "SELECT * FROM Dish;";

    /**
     * DAO constructor
     *
     * @throws DAOException
     */
    public DishDAO() throws DAOException {
        super();
        entityClass = Dish.class;
    }

    public List<Dish> getAllDishes() throws DAOException {
        return em.createQuery("FROM Dish d")
                .getResultList();
    }

    @Nullable
    public Dish getDishById(int dishId) throws DAOException {
        try {
            List<Dish> dishes =  em.createQuery("Select d From Dish d " +
                    "where d.id = :id")
                    .setParameter("id", dishId)
                    .getResultList();
            if(dishes.size() > 0){
                return dishes.get(0);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new DAOException("Can't read Dish by Dish id " + dishId, e);
        }
    }

    public void updateDishById(int id, String name, int cost) {
        List<Dish> dishes =  em.createQuery("Select d From Dish d " +
                "where d.id = :id")
                .setParameter("id", id)
                .getResultList();
        Dish dish = dishes.get(0);
        dish.setName(name);
        dish.setCost(cost);
        em.merge(dish);
    }
}
