/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import acceso_datos.exceptions.NonexistentEntityException;
import acceso_datos.exceptions.RollbackFailureException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Misael
 * 
 * CLASE BASE CONTROLADORA
 * 
 * es la clase base para un producto en el método de fabricación
 */
public abstract class ControladoraBase<T> {
    
    private Class<T> entidad;
    protected static EntityManagerFactory emf = null;
    protected UserTransaction utx = null;
    
    public ControladoraBase(Class<T> entidad, EntityManagerFactory e, UserTransaction u) {
        this.entidad = entidad;
        if(emf == null)
            emf = e;
        this.utx = u;
    }
    
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /**
     * 
     * @param e es una entidad
     */
    public void create(T e) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(e); //guarda en la base de datos
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("Se produjo un error al intentar revertir la transaccion", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public abstract void edit(T e) throws NonexistentEntityException, RollbackFailureException, Exception;
    
    public abstract void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception;
    
    
    public List<T> findEntidadEntities() {
        return findEntidadEntities(true, -1, -1);
    }

    public List<T> findEntidadEntities(int maxResults, int firstResult) {
        return findEntidadEntities(false, maxResults, firstResult);
    }

    private List<T> findEntidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entidad));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public T findEntidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entidad, id);
        } finally {
            em.close();
        }
    }

    public int getEntidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(entidad);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
