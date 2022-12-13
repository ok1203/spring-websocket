package com.company.websocket.service;


import com.company.websocket.Log;
import com.company.websocket.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepo repo;

    public List<Log> listAll() {
        return (List<Log>) repo.findAll();
    }

    public Log get(Integer Id) throws LogNotFoundException {
        Optional<Log> result = repo.findById(Id);
        if(result.isPresent()){
            return result.get();
        }
        throw new LogNotFoundException("   error" + Id);
    }

    public void save(Log log) {
        repo.save(log);
    }
}
