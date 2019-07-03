package com.springHibernet.springHibernet.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(nullable = false)
    @Size(min = 3, max = 15)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP) // only data DATE only TIME,TIMESTAMP date time both
    private Date birthDate;

    @Column(unique = true,nullable = false)
    private String mobileNo;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    @OneToMany(mappedBy = "contracts")
    private Set<Hobby> hobbies;
}
