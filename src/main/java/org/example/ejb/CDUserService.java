package org.example.ejb;

import jakarta.ejb.Remote;


@Remote
public interface CDUserService {
    String borrowCD(Long userId, Long cdId);
    String returnCD(Long userId, Long cdId);
}


