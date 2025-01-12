/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Alex
 */
@Stateless
@LocalBean
@Counter
@WebService
public class AutoPartsEJB implements AutoPartsEJBRemote {

    @Inject
    private EntityManager em;

    @Override
    public List<AutoParts> findAll() {
        TypedQuery<AutoParts> query = em.createNamedQuery("AutoParts.findAll", AutoParts.class);
        return query.getResultList();
    }

    @Override
    public List<AutoParts> findByCategory(Category category) {
        TypedQuery<AutoParts> query = em.createNamedQuery("AutoParts.findByCategory", AutoParts.class);
        query.setParameter("category", category);
        return query.getResultList(); 
    }
    
    @Override
    public List<AutoParts> needOrder() {
        TypedQuery<AutoParts> query = em.createNamedQuery("AutoParts.needOrder", AutoParts.class);
        return query.getResultList();
    }

    @Override
    public AutoParts findById(int id) {
        return em.find(AutoParts.class, id);
    }

    @Override
    public AutoParts createPart(AutoParts part) {
        em.persist(part);
        return part;
    }

    @Override
    public AutoParts updatePart(AutoParts part) {
        return em.merge(part);
    }

    @Override
    public void deletePart(AutoParts part) {
        AutoParts toDelete = em.merge(part);
        em.remove(toDelete);
    }
}
