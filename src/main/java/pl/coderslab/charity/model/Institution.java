package pl.coderslab.charity.model;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class Institution {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;





    public Institution() {
    }

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
