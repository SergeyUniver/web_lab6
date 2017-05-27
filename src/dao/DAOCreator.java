package dao;

/**
 * Created by Serug on 21.05.2017.
 */
public interface DAOCreator {

    ClientDAO getClientDAO();
    DishDAO getDishDAO();
    OrderDAO getOrderDAO();


}
