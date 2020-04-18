package com.wrn.handlefiles.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wrn.handlefiles.model.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

}
