package com.rhiodamuthie.jpaembeddabledemo;

import com.rhiodamuthie.jpaembeddabledemo.model.Address;
import com.rhiodamuthie.jpaembeddabledemo.model.Name;
import com.rhiodamuthie.jpaembeddabledemo.model.User;
import com.rhiodamuthie.jpaembeddabledemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaEmbeddableDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaEmbeddableDemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		// Cleanup the users table
		userRepository.deleteAllInBatch();

		// Insert a new user in the database
		Name name = new Name("Rhioda", "V", "Muthie");
		Address address = new Address("25", "Tebet", "Jakarta", "DKI Jakarta", "Indonesia", "560008");
		User user = new User(name, "rhioda.m@gmail.com", address);

		userRepository.save(user);
	}
}
