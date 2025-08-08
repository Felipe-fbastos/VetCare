package com.Vetcare.vetcare_api.Service;

import com.Vetcare.vetcare_api.Entity.Consulta;
import com.Vetcare.vetcare_api.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public String addConsulta(Consulta consulta){
        repository.save(consulta);
        return "Consulta cadastrada";
    }

    public List<Consulta> findAllConsultas(){
        return repository.findAll();
    }

    public Consulta findConsultaById(int id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Consulta não cadastrada")
        );
    }

    public String deleteConsulta(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Consulta não encontrada");
        }
        repository.deleteById(id);
        return "Consulta Deletada";

    }

    public String updateConsulta(int id, Consulta consulta){

       Consulta consultaEntity = repository.findById(id).orElseThrow( () ->
                new RuntimeException("Consulta não encontrada")
        );

        Consulta consultaAtualizada = Consulta.builder()
                .id(consultaEntity.getId())
                .motivoConsulta(consulta.getMotivoConsulta() != null ? consulta.getMotivoConsulta() :
                        consultaEntity.getMotivoConsulta())
                .veterinario(consulta.getVeterinario() != null ? consulta.getVeterinario() :
                        consultaEntity.getVeterinario())
                .pet(consulta.getPet() != null ? consulta.getPet() :
                        consultaEntity.getPet())
                .descricao(consulta.getDescricao() != null ? consulta.getDescricao() :
                        consultaEntity.getDescricao())
                .dataConsulta(consultaEntity.getDataConsulta())
                .build();
                repository.save(consultaAtualizada);

                return "Consulta atualizada!";

    }
}
