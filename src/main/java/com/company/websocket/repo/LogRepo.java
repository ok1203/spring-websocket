package com.company.websocket.repo;


import com.company.websocket.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends CrudRepository<Log, Integer> {

    public Long countById(Integer id);

}
