package pl.coderslab.charity.model;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
public class Institution {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<Donation> donation;

    public Institution(List<Donation> donation) {
        this.donation = donation;
    }

    public Institution() {
    }

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public List<Donation> getDonation() {
        return donation;
    }

    public void setDonation(List<Donation> donation) {
        this.donation = donation;
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
