package com.Petz.vetcare_api.infrastructure.repository;

import com.Petz.vetcare_api.infrastructure.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

}
