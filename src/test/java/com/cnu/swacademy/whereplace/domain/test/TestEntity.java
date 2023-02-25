package com.cnu.swacademy.whereplace.domain.test;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int test_id;

    private int intValue;

    private String stringValue;
}
