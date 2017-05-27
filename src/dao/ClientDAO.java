package dao;


import entities.Client;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Sergey on 20.02.2017.
 */
@Stateless
public class ClientDAO extends DAO {

    private static final String SQLRequestGetAllClients = "SELECT * FROM Client;";

    /**
     * DAO constructor
     *
     * @throws DAOException
     */
    public ClientDAO() throws DAOException {
        super();
        entityClass = Client.class;
    }

    public List<Client> getAllClient() throws DAOException {
            return em.createQuery("FROM Client c")
                    .getResultList();
    }
}
