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
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UtilisateurID")
    private Long code;
    @Column(unique = true,nullable = false)
    private String login;
    @Column(unique = true,nullable = false)
    private String password;
    private Role role ;

}

