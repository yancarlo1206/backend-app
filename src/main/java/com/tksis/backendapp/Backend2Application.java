package com.tksis.backendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Backend2Application implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Backend2Application.class, args);
	} 

	@Override
	public void run(String... args) throws Exception {
		
		for(int i=0; i<2; i++) {
			System.out.println(passwordEncoder.encode("1234"));
		}
		
	}
	
}
