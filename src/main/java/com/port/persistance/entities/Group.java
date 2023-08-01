package com.port.persistance.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_GROUP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "GR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "GR_PRIVILEGED", unique = true, nullable = false)
    private String privileged;

    public Group(String privileged) {
        this.privileged = privileged;
    }
}