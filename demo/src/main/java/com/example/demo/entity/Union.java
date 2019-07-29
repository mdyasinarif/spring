package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "u_nion")
public class Union {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String note;

    @ManyToOne
    @JoinColumn(name = "thana_id")
    private Thana thana;
}

