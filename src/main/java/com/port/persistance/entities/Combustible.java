package com.port.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Combustible implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private double prix;
    private LocalDateTime dateSaisie;
    @ManyToOne
    @JoinColumn(name ="USER_ID" ,referencedColumnName = "U_ID")
    private  User user;

}
