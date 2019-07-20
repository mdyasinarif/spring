package entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class FamilyMamber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String nidNo;
    private String gender;
    private Date dateOfBirth;
    private String education;
    private String contractNo;

}
