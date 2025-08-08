package com.Vetcare.vetcare_api.Service;


import com.Vetcare.vetcare_api.Entity.Pet;
import com.Vetcare.vetcare_api.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet savePet(Pet pet){
        return repository.save(pet);
    }

    public List<Pet> findAllPet(){
        return repository.findAll();
    }

    public Pet findPetById(int id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Pet não encontrado")
        );
    }

    public String deletePetById(int id){
        if (!repository.existsById(id)){
            return "Pet não encontrado";
        }
        repository.deleteById(id);
        return "Pet deletado";
    }

    public String updatePet(int id, Pet pet){
        Pet petEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Pet não encontrado")
        );

        Pet petAtualizado = Pet.builder()
                .nome(pet.getNome() != null ? pet.getNome() :
                        petEntity.getNome())
                .especie(pet.getEspecie() != null ? pet.getEspecie() :
                        petEntity.getEspecie())
                .peso(pet.getPeso() != null ? pet.getPeso() :
                        petEntity.getPeso())
                .raca(pet.getRaca() != null ? pet.getRaca() :
                        petEntity.getRaca())
                .castrado(pet.getCastrado() != null ? pet.getCastrado()
                        : petEntity.getCastrado())
                .id(petEntity.getId())
                .build();
                 repository.save(petAtualizado);
            return "Pet atualizado";
    }

}
