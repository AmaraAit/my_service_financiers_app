package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Client;
import com.example.demo.enumerate.UserRole;
import com.example.demo.repository.ClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ClientRepository clientRepository) {
		return args->{
			Client client1 = new Client();
			
			client1.setFirstName("John");
			client1.setLastName("Doe");
			client1.setPhoneNumber(1234567890L);
			client1.setAdresse("123 Main St, New York, NY");
			client1.setEmail("john.doe@example.com");
			client1.setPassword("password123");
			client1.setRole(UserRole.CLIENT);
			client1.activateAccount();
			clientRepository.save(client1);
			
			Client client2 = new Client();
			client2.setId(2);
			client2.setFirstName("Jane");
			client2.setLastName("Smith");
			client2.setPhoneNumber(9876543210L);
			client2.setAdresse("456 Elm St, Los Angeles, CA");
			client2.setEmail("jane.smith@example.com");
			client2.setPassword("password456");
			client2.setRole(UserRole.ADMIN);
			client2.desactivateAccount();
			clientRepository.save(client2);

			Client client3 = new Client();
			client3.setId(3);
			client3.setFirstName("Alice");
			client3.setLastName("Johnson");
			client3.setPhoneNumber(1112223333L);
			client3.setAdresse("789 Oak St, Chicago, IL");
			client3.setEmail("alice.johnson@example.com");
			client3.setPassword("password789");
			client3.setRole(UserRole.CLIENT);
			client3.activateAccount();
			clientRepository.save(client3);

			Client client4 = new Client();
			client4.setId(4);
			client4.setFirstName("Bob");
			client4.setLastName("Williams");
			client4.setPhoneNumber(4445556666L);
			client4.setAdresse("321 Pine St, San Francisco, CA");
			client4.setEmail("bob.williams@example.com");
			client4.setPassword("password321");
			client4.setRole(UserRole.ADMIN);
			client4.activateAccount();
			clientRepository.save(client4);

			Client client5 = new Client();
			client5.setId(5);
			client5.setFirstName("Charlie");
			client5.setLastName("Brown");
			client5.setPhoneNumber(7778889999L);
			client5.setAdresse("654 Maple St, Boston, MA");
			client5.setEmail("charlie.brown@example.com");
			client5.setPassword("password654");
			client5.setRole(UserRole.CLIENT);
			client5.desactivateAccount();
			clientRepository.save(client5);

			Client client6 = new Client();
			client6.setId(6);
			client6.setFirstName("David");
			client6.setLastName("Miller");
			client6.setPhoneNumber(1010101010L);
			client6.setAdresse("987 Cedar St, Miami, FL");
			client6.setEmail("david.miller@example.com");
			client6.setPassword("password987");
			client6.setRole(UserRole.CLIENT);
			client6.activateAccount();
			clientRepository.save(client6);

			Client client7 = new Client();
			client7.setId(7);
			client7.setFirstName("Eva");
			client7.setLastName("Martinez");
			client7.setPhoneNumber(1212121212L);
			client7.setAdresse("432 Birch St, Seattle, WA");
			client7.setEmail("eva.martinez@example.com");
			client7.setPassword("password432");
			client7.setRole(UserRole.ADMIN);
			client7.activateAccount();
			clientRepository.save(client7);

			Client client8 = new Client();
			client8.setId(8);
			client8.setFirstName("Frank");
			client8.setLastName("Garcia");
			client8.setPhoneNumber(1313131313L);
			client8.setAdresse("876 Spruce St, Austin, TX");
			client8.setEmail("frank.garcia@example.com");
			client8.setPassword("password876");
			client8.setRole(UserRole.CLIENT);
			client8.desactivateAccount();
			clientRepository.save(client8);

			Client client9 = new Client();
			client9.setId(9);
			client9.setFirstName("Grace");
			client9.setLastName("Hernandez");
			client9.setPhoneNumber(1414141414L);
			client9.setAdresse("543 Aspen St, Denver, CO");
			client9.setEmail("grace.hernandez@example.com");
			client9.setPassword("password543");
			client9.setRole(UserRole.CLIENT);
			client9.activateAccount();
			clientRepository.save(client9);

			Client client10 = new Client();
			client10.setId(10);
			client10.setFirstName("Hank");
			client10.setLastName("Lopez");
			client10.setPhoneNumber(1515151515L);
			client10.setAdresse("654 Redwood St, Dallas, TX");
			client10.setEmail("hank.lopez@example.com");
			client10.setPassword("password654");
			client10.setRole(UserRole.ADMIN);
			client10.desactivateAccount();
			clientRepository.save(client10);
			
			
		};
	}

}
