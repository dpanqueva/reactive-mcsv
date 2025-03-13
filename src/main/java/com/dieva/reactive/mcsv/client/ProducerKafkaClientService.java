package com.dieva.reactive.mcsv.client;

import com.dieva.reactive.mcsv.model.Profession;

public interface ProducerKafkaClientService {

    public String sendToProducerKafka(Profession profession);
}
