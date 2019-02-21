package com.rhiodamuthie.jpaonetoonedemo;

import com.rhiodamuthie.jpaonetoonedemo.model.Gender;
import com.rhiodamuthie.jpaonetoonedemo.model.User;
import com.rhiodamuthie.jpaonetoonedemo.model.UserProfile;
import com.rhiodamuthie.jpaonetoonedemo.repository.UserProfileRepository;
import com.rhiodamuthie.jpaonetoonedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class JpaOneToOneDemoApplication implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		//=========================================

		// Create a User instance
		User user = new User("Rhioda", "Muthie", "rhioda.m@gmail.com",
				"MY_SUPER_SECRET_PASSWORD");

		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1992, 7, 21);

		// Create a UserProfile instance
		UserProfile userProfile = new UserProfile("+6285271062544", Gender.MALE, dateOfBirth.getTime(),
				"747", "2nd Cross", "Jln Tebet Barat Dalam VII 25c", "Jakarta",
				"DKI Jakarta", "Indonesia", "560008");


		// Set child reference(userProfile) in parent entity(user)
		user.setUserProfile(userProfile);

		// Set parent reference(user) in child entity(userProfile)
		userProfile.setUser(user);

		// Save Parent Reference (which will save the child as well)
		userRepository.save(user);

		//=========================================
	}

}
