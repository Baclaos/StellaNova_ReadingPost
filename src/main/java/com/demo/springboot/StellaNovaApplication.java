package com.demo.springboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@SpringBootApplication
@EnableDiscoveryClient
public class StellaNovaApplication {
	public static void main(String[] args) {
		SpringApplication.run(StellaNovaApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(AccountService accountManager)
//	{
//		return args -> {
////			accountManager.saveRole(new Role(null, "ROLE_USER"));
////			accountManager.saveRole(new Role(null, "ROLE_ADMIN"));
//
////			accountManager.AddUser(new AccountDTO(Long.valueOf(6), "jrut4", "test","test", new ArrayList<>()));
//
////			accountManager.AddRoleToUser("jrut4", "ROLE_USER");
//		};
//	}


}
