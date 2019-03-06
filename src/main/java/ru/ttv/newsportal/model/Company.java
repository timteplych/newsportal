package ru.ttv.newsportal.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Timofey Teplykh
 */
@Entity
@Table(name="np_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp="[A-Z][a-zA-Z]*",message="{validation.company.title.pattern}")
    @Size(min=2, max=50, message="{validation.company.name.size}")
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="address")
    private String address;

    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="{validation.company.email.pattern}")
    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Pattern(regexp="^[a-zA-Z0-9._-]{3,}$", message="{validation.company.login.pattern}")
    @Column(name = "login")
    private String login;

    @Pattern(regexp=".{8,}", message="{validation.company.password.pattern}")
    @Column(name = "password")
    private String password;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
