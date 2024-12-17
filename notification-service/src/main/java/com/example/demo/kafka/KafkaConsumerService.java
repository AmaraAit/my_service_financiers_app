package com.example.demo.kafka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	
	
	 private  String messages;

	    // Méthode KafkaListener pour consommer les messages
	    @KafkaListener(topics = "test-topic", groupId = "my-consumer-group")
	    public void listen(String record) {
	        // Ajouter le message reçu à la liste
	        messages=record;
	        System.out.println("Message reçu : " + record);
	    }

	    // Getter pour les messages reçus
	    public String getMessages() {
	        return messages;
	    }
}
