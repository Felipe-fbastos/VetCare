package com.Vetcare.vetcare_api.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tutor_Pet")
public class TutorPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTutor_Pet")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "idTutor")
    private Tutor tutor;
}
