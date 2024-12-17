package com.example.demo.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	
	 @Bean
	    public ConsumerFactory<String, String> consumerFactory() {
	        Map<String, Object> consumerProps = new HashMap<>();
	        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-consumer-group");
	        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	        consumerProps.put("session.timeout.ms", "30000");
	        
	        // Heartbeat interval : Vérifiez que ce temps est inférieur à `session.timeout.ms`
	        consumerProps.put("heartbeat.interval.ms", "10000");
	        
	        // Le maximum entre deux appels `poll()` : Par défaut 5 minutes, mais vous pouvez ajuster
	        consumerProps.put("max.poll.interval.ms", "30000000");
	        
	        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        return new DefaultKafkaConsumerFactory<>(consumerProps);
	    }

	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String , String> containerFactory= new ConcurrentKafkaListenerContainerFactory<>();
		containerFactory.setConsumerFactory(consumerFactory());
		return containerFactory;
	}

}
