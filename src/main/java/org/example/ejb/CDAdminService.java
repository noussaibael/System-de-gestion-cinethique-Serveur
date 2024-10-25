package org.example.ejb;

import org.example.entity.CD;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface CDAdminService {
    List<CD> listCDs();
    CD createCD(CD cd);
    CD updateCD(CD cd);
    void deleteCD(Long id);
}
