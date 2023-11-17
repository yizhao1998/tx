package com.spring.demo.tx.dao;

import com.spring.demo.tx.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Query("SELECT q FROM Classroom q WHERE q.id = ?1")
    List<Classroom> getClassroomById(Long id);
}
