package com.dieva.reactive.mcsv.service;

import com.dieva.reactive.mcsv.model.Profession;
import com.dieva.reactive.mcsv.repository.ProfessionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    private final ProfessionRepository professionRepository;

    public ProfessionServiceImpl(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    @Override
    public Mono<Profession> createProfession(Profession profession) {
        return Mono.just(profession).flatMap(professionRepository::save);
    }

    @Override
    public Mono<Profession> getProfessionById(Long id) {
        return professionRepository.findById(id);
    }

    @Override
    public Mono<Profession> updateProfession(Profession profession, Long id) {
        return null;
    }

    @Override
    public Mono<Void> deleteProfessionById(Long id) {
        return professionRepository.deleteById(id);
    }

    @Override
    public Flux<Profession> getProfessions() {
        return professionRepository.findAll();
    }

    @Override
    public Flux<Profession> getProfessionByCode(String code) {
        return professionRepository.findByCode(code);
    }
}
