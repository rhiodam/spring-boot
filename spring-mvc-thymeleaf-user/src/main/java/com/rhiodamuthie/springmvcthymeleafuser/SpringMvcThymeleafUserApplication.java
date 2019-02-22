package com.rhiodamuthie.springmvcthymeleafuser;

import com.rhiodamuthie.springmvcthymeleafuser.model.User;
import com.rhiodamuthie.springmvcthymeleafuser.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringMvcThymeleafUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcThymeleafUserApplication.class, args);
	}

	//	Initialize data to db
	@Bean
	CommandLineRunner init(UserRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 30)
					.mapToObj(i -> {
						User c = new User();
						c.setName("User " + i);
						c.setEmail("user" + i + "@email.com");
//						c.setPhone("(111) 111-1111");
//						c.setAddress("Address no. " + i);

						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
