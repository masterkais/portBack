package com.port.persistance.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Sortie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    @ManyToOne
    @JoinColumn(name ="USER_ID" ,referencedColumnName = "U_ID")
    private  User user;
}
