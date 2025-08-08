package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Consulta")
public class Consulta {

    @Id
    @Column(name = "idConsulta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idMotivoConsulta")
    private MotivoConsulta motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "idVeterinario")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private Pet pet;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataConsulta")
    private LocalDateTime dataConsulta = LocalDateTime.now();

}
