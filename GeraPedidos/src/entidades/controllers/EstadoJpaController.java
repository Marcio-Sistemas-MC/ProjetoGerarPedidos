/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.banco.Pais;
import entidades.banco.Cidade;
import entidades.banco.Estado;
import entidades.controllers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Paulo
 */
public class EstadoJpaController implements Serializable {

    public EstadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estado estado) {
        if (estado.getCidadeCollection() == null) {
            estado.setCidadeCollection(new ArrayList<Cidade>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pais pais = estado.getPais();
            if (pais != null) {
                pais = em.getReference(pais.getClass(), pais.getId());
                estado.setPais(pais);
            }
            Collection<Cidade> attachedCidadeCollection = new ArrayList<Cidade>();
            for (Cidade cidadeCollectionCidadeToAttach : estado.getCidadeCollection()) {
                cidadeCollectionCidadeToAttach = em.getReference(cidadeCollectionCidadeToAttach.getClass(), cidadeCollectionCidadeToAttach.getId());
                attachedCidadeCollection.add(cidadeCollectionCidadeToAttach);
            }
            estado.setCidadeCollection(attachedCidadeCollection);
            em.persist(estado);
            if (pais != null) {
                pais.getEstadoCollection().add(estado);
                pais = em.merge(pais);
            }
            for (Cidade cidadeCollectionCidade : estado.getCidadeCollection()) {
                Estado oldEstadoOfCidadeCollectionCidade = cidadeCollectionCidade.getEstado();
                cidadeCollectionCidade.setEstado(estado);
                cidadeCollectionCidade = em.merge(cidadeCollectionCidade);
                if (oldEstadoOfCidadeCollectionCidade != null) {
                    oldEstadoOfCidadeCollectionCidade.getCidadeCollection().remove(cidadeCollectionCidade);
                    oldEstadoOfCidadeCollectionCidade = em.merge(oldEstadoOfCidadeCollectionCidade);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estado estado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado persistentEstado = em.find(Estado.class, estado.getId());
            Pais paisOld = persistentEstado.getPais();
            Pais paisNew = estado.getPais();
            Collection<Cidade> cidadeCollectionOld = persistentEstado.getCidadeCollection();
            Collection<Cidade> cidadeCollectionNew = estado.getCidadeCollection();
            if (paisNew != null) {
                paisNew = em.getReference(paisNew.getClass(), paisNew.getId());
                estado.setPais(paisNew);
            }
            Collection<Cidade> attachedCidadeCollectionNew = new ArrayList<Cidade>();
            for (Cidade cidadeCollectionNewCidadeToAttach : cidadeCollectionNew) {
                cidadeCollectionNewCidadeToAttach = em.getReference(cidadeCollectionNewCidadeToAttach.getClass(), cidadeCollectionNewCidadeToAttach.getId());
                attachedCidadeCollectionNew.add(cidadeCollectionNewCidadeToAttach);
            }
            cidadeCollectionNew = attachedCidadeCollectionNew;
            estado.setCidadeCollection(cidadeCollectionNew);
            estado = em.merge(estado);
            if (paisOld != null && !paisOld.equals(paisNew)) {
                paisOld.getEstadoCollection().remove(estado);
                paisOld = em.merge(paisOld);
            }
            if (paisNew != null && !paisNew.equals(paisOld)) {
                paisNew.getEstadoCollection().add(estado);
                paisNew = em.merge(paisNew);
            }
            for (Cidade cidadeCollectionOldCidade : cidadeCollectionOld) {
                if (!cidadeCollectionNew.contains(cidadeCollectionOldCidade)) {
                    cidadeCollectionOldCidade.setEstado(null);
                    cidadeCollectionOldCidade = em.merge(cidadeCollectionOldCidade);
                }
            }
            for (Cidade cidadeCollectionNewCidade : cidadeCollectionNew) {
                if (!cidadeCollectionOld.contains(cidadeCollectionNewCidade)) {
                    Estado oldEstadoOfCidadeCollectionNewCidade = cidadeCollectionNewCidade.getEstado();
                    cidadeCollectionNewCidade.setEstado(estado);
                    cidadeCollectionNewCidade = em.merge(cidadeCollectionNewCidade);
                    if (oldEstadoOfCidadeCollectionNewCidade != null && !oldEstadoOfCidadeCollectionNewCidade.equals(estado)) {
                        oldEstadoOfCidadeCollectionNewCidade.getCidadeCollection().remove(cidadeCollectionNewCidade);
                        oldEstadoOfCidadeCollectionNewCidade = em.merge(oldEstadoOfCidadeCollectionNewCidade);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estado.getId();
                if (findEstado(id) == null) {
                    throw new NonexistentEntityException("The estado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado estado;
            try {
                estado = em.getReference(Estado.class, id);
                estado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estado with id " + id + " no longer exists.", enfe);
            }
            Pais pais = estado.getPais();
            if (pais != null) {
                pais.getEstadoCollection().remove(estado);
                pais = em.merge(pais);
            }
            Collection<Cidade> cidadeCollection = estado.getCidadeCollection();
            for (Cidade cidadeCollectionCidade : cidadeCollection) {
                cidadeCollectionCidade.setEstado(null);
                cidadeCollectionCidade = em.merge(cidadeCollectionCidade);
            }
            em.remove(estado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estado> findEstadoEntities() {
        return findEstadoEntities(true, -1, -1);
    }

    public List<Estado> findEstadoEntities(int maxResults, int firstResult) {
        return findEstadoEntities(false, maxResults, firstResult);
    }

    private List<Estado> findEstadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estado.class));
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

    public Estado findEstado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estado> rt = cq.from(Estado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
