package com.example.TripEvaluator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String destination;
    @Column
    private int cena;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Trip() {

    }

    public Trip(Integer id, String title, String destination, int cena, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.cena = cena;
        this.reviews = reviews;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", destination='" + destination + '\'' +
                ", cena=" + cena +
                ", reviews=" + reviews +
                '}';
    }
}
