package dao;


import entities.Client;
import entities.Dish;
import entities.Order;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Sergey on 20.02.2017.
 */
@Stateless
public class OrderDAO extends DAO {

    private static final String COMMON_REQUEST = "SELECT * FROM restaurant.`order` " +
            "JOIN client ON restaurant.`order`.client_id = restaurant.`client`.id " +
            "JOIN dish ON restaurant.`order`.dish_id = restaurant.`dish`.id ";
    private static final String SQLRequestGetOrderByClient = COMMON_REQUEST +
            "WHERE restaurant.`order`.client_id = ?";
    private static final String SQLRequestGetOrderByAccept = COMMON_REQUEST +
            "WHERE restaurant.`order`.isAccepted = ?";
    private static final String SQLRequestInsertNewOrder = "INSERT into restaurant.`order`(dish_id, dish_count, client_id, isAccepted, isPayed) values (?, ?, 1, ?, ?)\n";

    /**
     * DAO constructor
     *
     * @throws DAOException
     */
    public OrderDAO() throws DAOException {
        super();
        entityClass = Order.class;
    }


    public List<Order> showOrdersByClient(final int clientId) throws DAOException {
        try {
            return em.createNamedQuery("Order.findByClientId")
                    .setParameter("client_id", clientId)
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Can't read Order by Client id " + clientId, e);
        }
    }

    public List<Order> getAcceptedOrders() throws DAOException {
        try {
            return em.createQuery("Select o From Order o " +
                    "where o.isAccepted = 1")
                    .getResultList();
        } catch (Exception e) {
            throw new DAOException("Can't get accepted Orders");
        }
    }

    public void makeOrder(final int dishId, final int count, final boolean isPayed, final boolean isAccepted, DishDAO dishDAO, ClientDAO clientDAO) throws DAOException {
        try {
//            utx.begin();
            Order order = new Order();
            order.setDishCount(count);
            order.setIsPayed((byte) (isPayed ? 1 : 0));
            order.setIsAccepted((byte) (isAccepted ? 1 : 0));
            order.setDishByDishId((Dish) dishDAO.readEntity(dishId));
            order.setClientByClientId((Client) clientDAO.readEntity(0));
            order.setId(getCurrentId());
            em.persist(order);
//            utx.commit();
        } catch (Exception e) {
//            em.getTransaction().rollback();
            throw new DAOException("Can't save order");
        }
    }

    private int getCurrentId() throws DAOException {
        try {
            List<Order> orders = em.createQuery("from Order o")
                    .getResultList();
            int maxId = 0;
            for(Order order : orders){
                if(maxId < order.getId()){
                    maxId = order.getId();
                }
            }
            return maxId+1;
        } catch (Exception e) {
            throw new DAOException("Can't find last item", e);
        }
    }
}
