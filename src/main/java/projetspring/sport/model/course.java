package projetspring.sport.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_course;
    private String name;
    private double nbHours;
    private double tariff;
    private int capacity;



    @OneToMany(mappedBy = "course")
    private List<subscriber_course> subscribersCourses;


    @OneToMany(mappedBy = "course")
    private List<coach> coaches;

    public course(long id_course, String name, double nbHours, double tariff, int capacity, List<subscriber_course> subscribersCourses, List<coach> coaches) {
        this.id_course = id_course;
        this.name = name;
        this.nbHours = nbHours;
        this.tariff = tariff;
        this.capacity = capacity;
        this.subscribersCourses = subscribersCourses;
        this.coaches = coaches;
    }


    public course() {
    }

    public long getId_course() {
        return id_course;
    }

    public void setId_course(long id_course) {
        this.id_course = id_course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNbHours() {
        return nbHours;
    }

    public void setNbHours(double nbHours) {
        this.nbHours = nbHours;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public List<coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<coach> coaches) {
        this.coaches = coaches;
    }
}