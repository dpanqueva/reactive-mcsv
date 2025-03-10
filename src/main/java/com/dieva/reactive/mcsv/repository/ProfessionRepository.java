package com.dieva.reactive.mcsv.repository;

import com.dieva.reactive.mcsv.model.Profession;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProfessionRepository extends ReactiveCrudRepository<Profession, Long> {
    Flux<Profession> findByCode(String code);
}
