package com.wrn.handlefiles.repositoty;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wrn.handlefiles.model.Events;

@Repository
public interface EventsRepository extends MongoRepository<Events, String> {

}
