package com.port.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Diesel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idChef;
    private LocalDateTime dateAlimentationDeStock;
    @JsonIgnore
    @OneToMany(mappedBy = "diesel", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<LigneStock> ligneStocks=new ArrayList<>();
}
