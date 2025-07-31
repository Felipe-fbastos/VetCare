package com.Petz.vetcare_api.controllers;

import com.Petz.vetcare_api.business.service.TutorService;
import com.Petz.vetcare_api.infrastructure.entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private TutorService service;

    @PostMapping
    public ResponseEntity<?> saveTutor(@RequestBody Tutor tutor){
        return ResponseEntity.ok().body(service.saveTutor(tutor));
    }

    @GetMapping
    public ResponseEntity<?> findAllTutor(){
        return ResponseEntity.ok().body(service.getAllTutor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTutor(@PathVariable("id") int id) {

        return ResponseEntity.ok().body(service.findTutor(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTutor(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.deleteByTutorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTutor(@PathVariable("id") int id, @RequestBody Tutor tutor){
        return ResponseEntity.ok().body(service.updateByIdTutor(id,tutor));
    }
}
