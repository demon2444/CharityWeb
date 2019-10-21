package pl.coderslab.charity.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String name;

    @ManyToMany
    private List<Donation> donations;





    /*public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(List<Donation> donations) {
        this.donations = donations;
    }*/

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
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
}
