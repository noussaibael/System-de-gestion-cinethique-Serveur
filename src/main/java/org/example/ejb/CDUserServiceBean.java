package org.example.ejb;

import org.example.entity.CD;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CDUserServiceBean implements CDUserService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public String borrowCD(Long userId, Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null && cd.isAvailable()) {
            cd.setAvailable(false);
            em.merge(cd);
            return "CD borrowed successfully.";
        }
        return "CD is not available.";
    }

    @Override
    public String returnCD(Long userId, Long cdId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null && !cd.isAvailable()) {
            cd.setAvailable(true);
            em.merge(cd);
            return "CD returned successfully.";
        }
        return "CD was not borrowed.";
    }
}
