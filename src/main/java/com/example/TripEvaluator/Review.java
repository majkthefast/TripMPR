package com.example.TripEvaluator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String content;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;
    @Column
    private Integer rating;
    @Column
    private Opinion opinion;

    public Review() {

    }

    public Review(Integer id, String content, List<Author> authors, Integer rating, Opinion opinion) {
        this.id = id;
        this.content = content;
        this.authors = authors;
        this.rating = rating;
        this.opinion = opinion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public void setOpinion(Opinion opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + authors + '\'' +
                ", rating=" + rating +
                ", opinion=" + opinion +
                '}';
    }
}
