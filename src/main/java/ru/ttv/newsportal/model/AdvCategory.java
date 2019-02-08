package ru.ttv.newsportal.model;

import javax.persistence.*;

/**
 * @author Timofey Teplykh
 */
@Entity
@Table(name="np_advcategory")
public class AdvCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
