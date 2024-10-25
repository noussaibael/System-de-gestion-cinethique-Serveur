package org.example.ejb;

import org.example.entity.CD;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class CDAdminServiceBean implements CDAdminService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CD> listCDs() {
        return em.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }

    @Override
    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }

    @Override
    public CD updateCD(CD cd) {
        return em.merge(cd);
    }

    @Override
    public void deleteCD(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            em.remove(cd);
        }
    }
}
