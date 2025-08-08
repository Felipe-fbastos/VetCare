package com.Vetcare.vetcare_api.Service;


import com.Vetcare.vetcare_api.Entity.Tutor;
import com.Vetcare.vetcare_api.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public String saveTutor(Tutor tutor){

        if(!repository.existsByCpf(tutor.getCpf())){
            repository.save(tutor);
        }
            throw new RuntimeException("Tutor já existente");

    }

    // Retorna todos os Usuarios
    public List<Tutor> getAllTutor(){
        return repository.findAll();
    }

    public Tutor findTutor(int id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Tutor não Encontrado")
        );
    }

    public String deleteByTutorId(int id){
        // Verifica a existência do id passado por parametro
        // Caso o Id passado não exista ele retorna uma mensagem de erro
        // Caso exista o Tutor é deletado
        if (!repository.existsById(id)){
            return  "Usuário não existente na base de dados";
        }
        repository.deleteById(id);
        return "Tutor deletado com sucesso!";
    }

    public String updateByIdTutor(int id, Tutor tutor){

        Tutor tutorEntity = repository.findById(id).orElseThrow( ()
        -> new RuntimeException("Tutor não encontrado")
        );

        // Pega o dado passado por parametro (tutor)
        // Verifica se o dado é diferente de nulo ( Não Nulo)
        // Caso o dado não seja nulo ele armazena o que está sendo passado pelo tutor
        // Caso o dado seja nulo, ele armazena o que estava armazenado no banco

        Tutor tutorAtulizado = Tutor.builder()
                .nome(tutor.getNome() != null ? tutor.getNome() :
                        tutorEntity.getNome())
                .sobrenome(tutor.getSobrenome() != null ? tutor.getSobrenome()
                        : tutorEntity.getSobrenome())
                .telefone(tutor.getTelefone() != null ? tutor.getTelefone()
                        : tutorEntity.getTelefone())
                .cpf(tutor.getCpf() != null ? tutor.getCpf() :
                        tutorEntity.getCpf())
                .id(tutorEntity.getId())
                .build();

        repository.save(tutorAtulizado);

        return "Tutor Atualizado";
    }

}
