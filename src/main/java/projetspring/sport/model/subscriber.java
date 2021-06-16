package projetspring.sport.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class subscriber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_subscriber ;

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String address;
    private int tel;
    private String startDate;
    private String expireDate;


    @JsonManagedReference
    @OneToMany(mappedBy = "subscriber")
    private List<subscriber_course> subscribersCourses;

    public subscriber(long id_subscriber, String firstName, String lastName, String gender, String email, String address, int tel, String startDate, String expireDate, List<subscriber_course> subscribersCourses) {
        this.id_subscriber = id_subscriber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.subscribersCourses = subscribersCourses;
    }

    public subscriber() {
    }

    public long getId_subscriber() {
        return id_subscriber;
    }

    public void setId_subscriber(long id_subscriber) {
        this.id_subscriber = id_subscriber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public List<subscriber_course> getSubscribersCourses() {
        return subscribersCourses;
    }

    public void setSubscribersCourses(List<subscriber_course> subscribersCourses) {
        this.subscribersCourses = subscribersCourses;
    }
}
