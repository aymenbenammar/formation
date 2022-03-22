package com.sb.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formateur implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FormateurId")
    private Long IdFormateur;
    private String Nom;
    private String Prenom;
    @Column(unique=true,nullable = false)
    private String email;
    @Column(unique=true,nullable = false)
    private Long tel;
    @Column(nullable = false)
    private String type;
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisme_id", insertable = false, updatable = false)
    private Organisme organisme;*/


}
