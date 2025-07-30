package com.Petz.vetcare_api.infrastructure.repository;

import com.Petz.vetcare_api.infrastructure.entity.Tutor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor,Integer> {

   boolean existsById(int id);
}
