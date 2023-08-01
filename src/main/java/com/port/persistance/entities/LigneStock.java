package com.port.persistance.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class LigneStock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private double prix_unitaire;
    @ManyToOne
    @JoinColumn(name ="D_ID" ,referencedColumnName = "id")
    private  Diesel diesel;

}
