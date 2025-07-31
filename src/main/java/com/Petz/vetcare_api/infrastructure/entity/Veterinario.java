package com.Petz.vetcare_api.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Veterinario")
@Builder
public class Veterinario {

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
    @Size(min = 11, max = 11)
    private String telefone;

    @Column(name = "especializacao")
    private String especializacao;


}
