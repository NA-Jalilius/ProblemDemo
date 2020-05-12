package com.example.demo.dao;

import com.example.demo.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ActionRepository")
public interface ActionRepository extends JpaRepository<Action, Integer> {

    @Query(value = "SELECT nextval('schema.action_id_seq')", nativeQuery = true)
    Integer getNextValFromIdActionSeq();

}
