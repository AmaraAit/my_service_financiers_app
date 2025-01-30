package com.example.demo;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(IUserService userService) {
		return args->{
			
			userService.addNewRole(new Role( 1, "USER"));
			userService.addNewRole(new Role( 2, "ADMIN"));
			userService.addNewRole(new Role(3, "USER_MANAGER"));
			userService.addNewRole(new Role(4, "ACCOUNT_MANAGER"));
			
			User client1 = new User();
			client1.setFirstName("John");
			client1.setLastName("Doe");
			client1.setPhoneNumber(1234567890L);
			client1.setAdresse("123 Main St, New York, NY");
			client1.setEmail("john.doe@example.com");
			client1.setPassword("password123");
			client1.activateAccount();
			userService.addUser(client1);
			userService.addRoleToUser( 1, "USER");
			
			
			User client2 = new User();
			
			client2.setFirstName("Jane");
			client2.setLastName("Smith");
			client2.setPhoneNumber(9876543210L);
			client2.setAdresse("456 Elm St, Los Angeles, CA");
			client2.setEmail("jane.smith@example.com");
			client2.setPassword("password456");
			client2.desactivateAccount();
			userService.addUser(client2);
			userService.addRoleToUser( 2, "USER");
			

			User client3 = new User();
			//client3.setId(3);
			client3.setFirstName("Alice");
			client3.setLastName("Johnson");
			client3.setPhoneNumber(1112223333L);
			client3.setAdresse("789 Oak St, Chicago, IL");
			client3.setEmail("alice.johnson@example.com");
			client3.setPassword("password789");
			client3.activateAccount();
			userService.addUser(client3);
			userService.addRoleToUser( 3, "USER");
			

			User client4 = new User();
			//client4.setId(4);
			client4.setFirstName("Bob");
			client4.setLastName("Williams");
			client4.setPhoneNumber(4445556666L);
			client4.setAdresse("321 Pine St, San Francisco, CA");
			client4.setEmail("bob.williams@example.com");
			client4.setPassword("password321");
			client4.activateAccount();
			userService.addUser(client4);
			userService.addRoleToUser( 4, "USER");
			
			User client5 = new User();
			//client5.setId(5);
			client5.setFirstName("Charlie");
			client5.setLastName("Brown");
			client5.setPhoneNumber(7778889999L);
			client5.setAdresse("654 Maple St, Boston, MA");
			client5.setEmail("charlie.brown@example.com");
			client5.setPassword("password654");
			client5.desactivateAccount();
			userService.addUser(client5);
			userService.addRoleToUser(5, "USER");
			userService.addRoleToUser( 5, "ADMIN");
			

			User client6 = new User();
			//client6.setId(6);
			client6.setFirstName("David");
			client6.setLastName("Miller");
			client6.setPhoneNumber(1010101010L);
			client6.setAdresse("987 Cedar St, Miami, FL");
			client6.setEmail("david.miller@example.com");
			client6.setPassword("password987");
			client6.activateAccount();
			userService.addUser(client6);
			userService.addRoleToUser( 6, "USER");
			

			User client7 = new User();
			//client7.setId(7);
			client7.setFirstName("Eva");
			client7.setLastName("Martinez");
			client7.setPhoneNumber(1212121212L);
			client7.setAdresse("432 Birch St, Seattle, WA");
			client7.setEmail("eva.martinez@example.com");
			client7.setPassword("password432");
			client7.activateAccount();
			userService.addUser(client7);
			userService.addRoleToUser(7, "ADMIN");
			userService.addRoleToUser( 7, "USER_MANAGER");
			

			User client8 = new User();
			//client8.setId(8);
			client8.setFirstName("Frank");
			client8.setLastName("Garcia");
			client8.setPhoneNumber(1313131313L);
			client8.setAdresse("876 Spruce St, Austin, TX");
			client8.setEmail("frank.garcia@example.com");
			client8.setPassword("password876");
			client8.desactivateAccount();
			userService.addUser(client8);
			userService.addRoleToUser( 8, "ADMIN");
			userService.addRoleToUser( 8, "USER");
			

			User client9 = new User();
			//client9.setId(9);
			client9.setFirstName("Grace");
			client9.setLastName("Hernandez");
			client9.setPhoneNumber(1414141414L);
			client9.setAdresse("543 Aspen St, Denver, CO");
			client9.setEmail("grace.hernandez@example.com");
			client9.setPassword("password543");
			client9.activateAccount();
			userService.addUser(client9);
			userService.addRoleToUser( 9, "ADMIN");
			

			User client10 = new User();
			//client10.setId(10);
			client10.setFirstName("Hank");
			client10.setLastName("Lopez");
			client10.setPhoneNumber(1515151515L);
			client10.setAdresse("654 Redwood St, Dallas, TX");
			client10.setEmail("hank.lopez@example.com");
			client10.setPassword("password654");
			client10.desactivateAccount();
			userService.addUser(client10);
			userService.addRoleToUser( 10, "ADMIN");
			userService.addRoleToUser( 10, "USER_MANAGER");
			userService.addRoleToUser(10, "USER");
			userService.addRoleToUser( 10, "ACCOUNT_MANAGER");
			
			
			
		};
	}

}
