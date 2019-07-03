package com.springHibernet.springHibernet.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;
    private String telType;
    private String telNmuber;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
