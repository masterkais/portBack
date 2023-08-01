package com.port.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "U_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String fax;
    private String email;
    private String city;
    private boolean active;
    private LocalDateTime dateNaissanced;
    private LocalDateTime dateCreated;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Group> groups = new ArrayList<>();
    @Column(name = "U_USER_NAME")
    private String login;
    @Column(name = "U_PASSWORD")
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Combustible> combustibleList=new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Sortie> sortieList=new ArrayList<>();

    public User(Long id, String nom, String prenom, String adress, String fax, String email, String ville, boolean active, LocalDateTime dateNaissanced, LocalDateTime dateCreated, String userName, String password) {
        this.id = id;
        this.firstName = nom;
        this.lastName = prenom;
        this.adress = adress;
        this.fax = fax;
        this.email = email;
        this.city = ville;
        this.active = active;
        this.dateNaissanced = dateNaissanced;
        this.dateCreated = dateCreated;
        this.groups = null;
        this.login = userName;
        this.password = password;
    }
}

