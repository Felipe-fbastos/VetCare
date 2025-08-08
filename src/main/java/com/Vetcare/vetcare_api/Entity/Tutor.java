package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTutor")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf", unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "telefone", unique = true)
    @Size(min = 11, max = 11)
    private String telefone;

    @OneToMany(mappedBy = "tutor")
    private List<TutorPet> tutorPets;

}
