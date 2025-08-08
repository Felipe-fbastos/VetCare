package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Motivo_Consulta")
public class MotivoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMotivoConsulta")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "motivoConsulta")
    private List<Consulta> consultas;
}
