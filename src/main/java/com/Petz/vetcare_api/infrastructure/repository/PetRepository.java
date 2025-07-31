package com.Petz.vetcare_api.infrastructure.repository;

import com.Petz.vetcare_api.infrastructure.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    boolean existsById(int integer);
}
