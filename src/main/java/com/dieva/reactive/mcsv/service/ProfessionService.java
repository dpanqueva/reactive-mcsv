package com.dieva.reactive.mcsv.service;

import com.dieva.reactive.mcsv.model.Profession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfessionService {

    public Mono<Profession> createProfession(Profession profession);

    public Mono<Profession> getProfessionById(Long id);

    public Mono<Profession> updateProfession(Profession profession, Long id);

    public Mono<Void> deleteProfessionById(Long id);

    public Flux<Profession> getProfessions();

    public Flux<Profession> getProfessionByCode(String code);
}
