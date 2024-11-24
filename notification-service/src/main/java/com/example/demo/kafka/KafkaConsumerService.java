package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "test_topic",groupId = "groupe_id")
	public void consume(String msg) {
		System.out.println("consumer message : "+msg );
	}

}
