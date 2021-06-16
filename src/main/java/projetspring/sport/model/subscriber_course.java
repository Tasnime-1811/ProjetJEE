package projetspring.sport.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.io.Serializable;


@Entity
public class subscriber_course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sc_id;


    @Transient
    private String courseName;
    private long subscriber_id;
    private long course_id;


    @ManyToOne
    @JoinColumn(name = "subscriber_id",insertable = false,updatable = false)
    private subscriber subscriber;


    @ManyToOne
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private course course;


    public subscriber_course(long sc_id,String courseName, long subscriber_id, long course_id, subscriber subscriber, course course) {
        this.sc_id = sc_id;
        this.courseName=courseName;
        this.subscriber_id = subscriber_id;
        this.course_id = course_id;
        this.subscriber = subscriber;
        this.course = course;
    }

    public subscriber_course() {
    }

    public long getSc_id() {
        return sc_id;
    }

    public void setSc_id(long sc_id) {
        this.sc_id = sc_id;
    }

    public long getSubscriber_id() {
        return subscriber_id;
    }

    public String getCourseName() {
        return this.course.getName();
    }

    public void setSubscriber_id(long subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public course getCourse() {
        return course;
    }

    public void setCourse(course course) {
        this.course = course;
    }
}
