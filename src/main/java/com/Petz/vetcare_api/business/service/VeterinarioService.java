package com.Petz.vetcare_api.business.service;

import com.Petz.vetcare_api.infrastructure.entity.Veterinario;
import com.Petz.vetcare_api.infrastructure.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    public Veterinario saveVeterinario(Veterinario veterinario){
        return repository.save(veterinario);
    }

    public List<Veterinario> findAllVeterinario(){
        return repository.findAll();
    }

    public Veterinario findVeterinarioById(int id){
        return repository.findById(id).orElseThrow( ()
            -> new RuntimeException("Veterinário não encontrado")
        );
    }

    public String deleteVeterinario(int id){

        if (!repository.existsById(id)){
            return "Veterinário não encontrado";
        }

        repository.deleteById(id);
        return "Veterinario deletado";

    }

    public String updateVeterinario(int id, Veterinario veterinario){
        Veterinario veterinarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Veterinário não encontrado")
        );

        Veterinario veterinarioAtualizado = Veterinario.builder()

                .nome(veterinario.getNome() != null ? veterinario.getNome() :
                        veterinarioEntity.getNome())
                .sobrenome(veterinario.getSobrenome() != null ? veterinario.getSobrenome() :
                        veterinarioEntity.getSobrenome())
                .cpf(veterinario.getCpf() != null ? veterinario.getCpf() :
                        veterinarioEntity.getCpf())
                .telefone(veterinario.getTelefone() != null ? veterinario.getCpf() :
                        veterinarioEntity.getTelefone())
                .especializacao(veterinario.getEspecializacao() != null ? veterinario.getEspecializacao()
                        : veterinarioEntity.getEspecializacao())
                .id(veterinarioEntity.getId())
                .build();

                return "Veterinario Atualizado";
    }

}
