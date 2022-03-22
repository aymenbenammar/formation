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
public class Participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ParticipantID")
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
}
