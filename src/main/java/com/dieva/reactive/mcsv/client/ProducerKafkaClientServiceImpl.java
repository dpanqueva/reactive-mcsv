package com.dieva.reactive.mcsv.client;


import com.dieva.reactive.mcsv.model.Profession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProducerKafkaClientServiceImpl implements ProducerKafkaClientService {

    private final WebClient webClient;

    public ProducerKafkaClientServiceImpl(WebClient.Builder webClientBuilder,  @Value("${base.url.kfk}") String url) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    @Override
    public String sendToProducerKafka(Profession profession) {
        return webClient.post()
                .uri("/send")
                .bodyValue(profession)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
