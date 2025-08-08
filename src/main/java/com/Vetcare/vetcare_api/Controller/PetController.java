package com.Vetcare.vetcare_api.Controller;


import com.Vetcare.vetcare_api.Entity.Pet;
import com.Vetcare.vetcare_api.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    @PostMapping
    public ResponseEntity<Pet> savePet(@RequestBody Pet pet){
        return ResponseEntity.ok().body(service.savePet(pet));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> findAllPet(){
        return ResponseEntity.ok().body(service.findAllPet());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findPet(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.findPetById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.deletePetById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePet(@PathVariable("id") int id, @RequestBody Pet pet){
        return ResponseEntity.ok().body(service.updatePet(id,pet));
    }


}
