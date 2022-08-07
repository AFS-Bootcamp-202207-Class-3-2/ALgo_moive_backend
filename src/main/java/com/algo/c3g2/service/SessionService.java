package com.algo.c3g2.service;

import com.algo.c3g2.entity.Session;
import com.algo.c3g2.exception.SessionExistException;
import com.algo.c3g2.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public Session getSessionById(String id) {
        return sessionRepository.findById(id).orElseThrow(SessionExistException::new);
    }
}
