package com.Petz.vetcare_api.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "Tutor")

public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf", unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "telefone", unique = true)
    private String telefone;

}
