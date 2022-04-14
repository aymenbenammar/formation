package com.sb.formation.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AuthorityId")
    private Long IdAuthority;

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles = new HashSet<>();

}
