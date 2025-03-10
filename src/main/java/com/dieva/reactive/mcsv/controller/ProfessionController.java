package com.dieva.reactive.mcsv.controller;

import com.dieva.reactive.mcsv.model.Profession;
import com.dieva.reactive.mcsv.service.ProfessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProfessionController {

    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping
    public Mono<ResponseEntity<Profession>> createProfession(@RequestBody Profession profession){
        return professionService.createProfession(profession)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Profession>>getProfessionById(@PathVariable Long id){
        return professionService.getProfessionById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public Flux<Profession> getAllProfessions(){
        return professionService.getProfessions();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Profession>> updateProfession(@PathVariable Long id, @RequestBody Profession updatedProfession){
        return professionService.updateProfession(updatedProfession, id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteProfession(@PathVariable Long id){
        return professionService.deleteProfessionById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
