package com.Petz.vetcare_api.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@Builder
@Table(name = "Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "especie")
    private String especie;

    /* Usa-se a classe Double
       pois o double (tipo primitvo)
       recebe 0,0 por padrão portanto
       não pode ser nulo
    */
    @Column(name = "peso")
    private Double peso;

    @Column(name = "raca")
    private String raca;

    @Column(name = "Castrado", length = 1)
    private String castrado;

}
