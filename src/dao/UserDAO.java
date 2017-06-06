package dao;

import entities.Dish;
import entities.User;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Ionas on 29.05.2017.
 */
@Stateless
public class UserDAO extends DAO{

    /**
     * DAO constructor
     *
     * @throws DAOException
     */
    public UserDAO() throws DAOException {
        super();
        entityClass = User.class;
    }

    public List<User> getAllUsers() throws DAOException {
        return em.createQuery("FROM User u")
                .getResultList();
    }

    public User tryAuthorize(String login, String password) throws DAOException {
        try {
            List<User> users =  em.createQuery("Select u From User u " +
                    "where u.login = :login")
                    .setParameter("login", login)
                    .getResultList();
            if(users.isEmpty()){
                return null;
            }else if(users.get(0).getPassword().equals(password)){
                return users.get(0);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new DAOException("Can't get User");
        }
    }

    public User createNewUser(String login, String password) throws DAOException {
        try {
            if(isUserExist(login)){
                return null;
            }
            User user = new User(getCurrentId(), login, password, User.USER_TYPE);
            em.persist(user);
            return user;
        } catch (Exception e) {
            throw new DAOException("Can't save order");
        }
    }

    private int getCurrentId() throws DAOException {
        try {
            List<User> orders = em.createQuery("from User o")
                    .getResultList();
            int maxId = 0;
            for(User order : orders){
                if(maxId < order.getId()){
                    maxId = order.getId();
                }
            }
            return maxId+1;
        } catch (Exception e) {
            throw new DAOException("Can't find last item", e);
        }
    }

    private boolean isUserExist(String login) {
        List<User> users =  em.createQuery("Select u From User u " +
                "where u.login = :login")
                .setParameter("login", login)
                .getResultList();
        return users.size() > 0;
    }
}