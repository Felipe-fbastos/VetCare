package com.Petz.vetcare_api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MotivoConsulta motivoConsulta;
    private Veterinario veterinario;
    private Pet pet;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataConsulta")
    private LocalDateTime dataConsulta = LocalDateTime.now();

}
