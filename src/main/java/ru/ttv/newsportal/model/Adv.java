package ru.ttv.newsportal.model;

import javax.persistence.*;

/**
 * @author Timofey Teplykh
 */
@Entity
@Table(name="np_adv")
public class Adv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="np_advcategory_id")
    private AdvCategory category;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="phone")
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdvCategory getCategory() {
        return category;
    }

    public void setCategory(AdvCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
