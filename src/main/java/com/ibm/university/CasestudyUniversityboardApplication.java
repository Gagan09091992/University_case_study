package com.ibm.university;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ibm.university.entity.User;
import com.ibm.university.repository.UserRepository;

@SpringBootApplication
public class CasestudyUniversityboardApplication {
//public class CasestudyUniversityboardApplication implements CommandLineRunner {
	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	public static void main(String[] args) {
		SpringApplication.run(CasestudyUniversityboardApplication.class, args);
	}

	
	/*
	 * public void run(String... args) throws Exception { if
	 * (this.userRepository.findByUsername("Gagan") == null) { User user = new User(
	 * "user","RealAdmin" ,passwordEncoder.encode("admin"), Arrays.asList("ADMIN"));
	 * 
	 * this.userRepository.save(user); } }
	 */
}
