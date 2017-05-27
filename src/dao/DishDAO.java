package dao;

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
}
