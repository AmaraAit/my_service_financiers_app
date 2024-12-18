package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate;
	
	private static final String TOPIC="test-topic";
	
	public void sendmsg(String msg) {
		kafkaTemplate.send(TOPIC,msg);
	}
	
	

}
