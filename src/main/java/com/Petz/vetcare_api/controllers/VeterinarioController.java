package com.Petz.vetcare_api.controllers;

import com.Petz.vetcare_api.business.service.VeterinarioService;
import com.Petz.vetcare_api.infrastructure.entity.Veterinario;
import com.Petz.vetcare_api.infrastructure.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @PostMapping
    public ResponseEntity<Veterinario> saveVeterinario(@RequestBody Veterinario vet){
        return ResponseEntity.ok().body(service.saveVeterinario(vet));
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> findAllVeterinario(){
        return ResponseEntity.ok().body(service.findAllVeterinario());
    }

    @GetMapping("/id")
    public ResponseEntity<Veterinario> findVeterinarioById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.findVeterinarioById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVeterinario(@PathVariable("id") int id, @RequestBody Veterinario vet){
        return ResponseEntity.ok().body(service.deleteVeterinario(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateVeterinario(@PathVariable("id") int id, @RequestBody Veterinario vet){
        return ResponseEntity.ok().body(service.updateVeterinario(id, vet));
    }

}
