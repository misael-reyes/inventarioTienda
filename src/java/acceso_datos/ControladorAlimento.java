/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import acceso_datos.exceptions.NonexistentEntityException;
import acceso_datos.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.transaction.UserTransaction;
import modelo.Alimento;

/**
 *
 * @author Misael
 */
public class ControladorAlimento extends ControladoraBase implements Serializable {

    public ControladorAlimento(EntityManagerFactory e, UserTransaction u) {
        super(Alimento.class, e, u);
    }

    @Override
    public void edit(Object arg0) throws NonexistentEntityException, RollbackFailureException, Exception {
        Alimento alim = (Alimento) arg0;
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            alim = em.merge(alim);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alim.getIdalimento();
                if (findEntidad(id) == null) {
                    throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Alimento alimento;
            try {
                alimento = em.getReference(Alimento.class, id);
                alimento.getIdalimento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(alimento);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
