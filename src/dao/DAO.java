package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Created by Sergey on 20.02.2017.
 */
public class DAO {

    private static final String UNIT_NAME = "primary";

    protected Class entityClass;

    @PersistenceContext(unitName = "simpleFactory")
    protected EntityManager em;

    /**
     * DAO constructor
     */
    public DAO() {

    }

    public void closeEntityManager() {
        em.close();
    }


    public Object readEntity(int id) throws DAOException {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery(entityClass);
            Root e = query.from(entityClass);
            query.select(e).where(cb.equal(e.get("id"), id));
            return entityClass.cast(em.createQuery(query).getSingleResult());
        } catch (Exception ex) {
            throw new DAOException("Cant't read " + entityClass.getSimpleName() + " with id " + id, ex);
        }
    }
}
