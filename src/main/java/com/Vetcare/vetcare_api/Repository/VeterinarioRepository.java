package com.Vetcare.vetcare_api.Repository;


import com.Vetcare.vetcare_api.Entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
    boolean existsByCpf(String cpf);
}
