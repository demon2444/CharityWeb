package pl.coderslab.charity.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity; //(liczba worków)

    private Category categories; //(lista obiektów typu Category) , pamiętaj o odpowiedniej adnotacji

    private Institution institution; // (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.

    private String street;
    private String city;
    private Long zipCode;
    private Date pickUpDate;
    private Date pickUpTime;
    private Date pickUpComment;

    public Donation() {
    }

    public Donation(Category categories, Institution institution) {
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

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
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
