package com.sb.formation.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FormationID")
    private Long id;
    private String titre;
    private int annee;
    private int nbSession;
    private int duree;
    private double budget;
}
