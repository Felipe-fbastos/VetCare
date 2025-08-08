package com.Vetcare.vetcare_api.Repository;


import com.Vetcare.vetcare_api.Entity.Tutor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor,Integer> {

   boolean existsById(int id);
   boolean existsByCpf(String cpf);
}
