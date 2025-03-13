package com.dieva.reactive.mcsv.service;

import com.dieva.reactive.mcsv.client.ProducerKafkaClientService;
import com.dieva.reactive.mcsv.model.Profession;
import com.dieva.reactive.mcsv.repository.ProfessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private static final Logger logger = LoggerFactory.getLogger(ProfessionServiceImpl.class);


    private final ProfessionRepository professionRepository;
    private final ProducerKafkaClientService producerKafkaClientService;

    public ProfessionServiceImpl(ProfessionRepository professionRepository, ProducerKafkaClientService producerKafkaClientService) {
        this.professionRepository = professionRepository;
        this.producerKafkaClientService = producerKafkaClientService;
    }

    @Override
    public Mono<Profession> createProfession(Profession profession) {
        return professionRepository.save(profession)
                .flatMap(savedProfession -> {
                    sendToProducerKafka(savedProfession);
                    return Mono.just(savedProfession);
                });
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

    private void sendToProducerKafka(Profession profession) {
        try{
            producerKafkaClientService.sendToProducerKafka(profession);
        }catch (Exception e){
            logger.error("Error sending to producer kafka", e.getMessage());
        }

    }
}
