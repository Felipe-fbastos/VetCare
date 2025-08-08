package com.Vetcare.vetcare_api.Repository;


import com.Vetcare.vetcare_api.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    boolean existsById(int integer);
}
