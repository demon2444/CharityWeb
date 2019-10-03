package pl.coderslab.charity.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity; //(liczba worków)

    @OneToMany(mappedBy = "donation")
    private List<Category> categories; //(lista obiektów typu Category) , pamiętaj o odpowiedniej adnotacji

    @OneToOne(mappedBy = "donation")
    private Institution institution; // (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.

    private String street;
    private String city;
    private Long zipCode;
    private Date pickUpDate;
    private Date pickUpTime;
    private Date pickUpComment;

    public Donation() {
    }

    public Donation(List<Category> categories, Institution institution) {
        this.categories = categories;
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Date getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(Date pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}
