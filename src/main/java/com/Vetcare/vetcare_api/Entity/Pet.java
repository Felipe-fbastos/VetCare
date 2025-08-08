package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPet")
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
    private Character castrado;

    @OneToMany(mappedBy = "pet")
    private List<TutorPet> tutorPets;

    @OneToMany(mappedBy = "pet")
    private List<Consulta> consultas;

}
