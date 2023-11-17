package com.spring.demo.tx.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "classrooms")
@Data
public class Classroom implements Serializable {

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "classroom_name")
    private String classroomName;
}
