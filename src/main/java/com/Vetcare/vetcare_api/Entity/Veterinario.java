package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Veterinario")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeterinario")
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

    @OneToMany(mappedBy = "veterinario")
    private List<Consulta> consultas;


}
