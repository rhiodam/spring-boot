package com.rhiodamuthie.springbootrest;

import com.rhiodamuthie.springbootrest.persistence.model.Foo;
import com.rhiodamuthie.springbootrest.persistence.repository.FooRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.LongStream;

@SpringBootApplication
//@EntityScan("com.rhiodamuthie.springbootrest.persistence.model")
//@EnableJpaRepositories("com.rhiodamuthie.springbootrest.persistence.dao")
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	//	Initialize data to db
	@Bean
	CommandLineRunner init(FooRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 30)
					.mapToObj(i -> {
						Foo c = new Foo();
						c.setName("User " + i);
//						c.setEmail("user" + i + "@email.com");
//						c.setPhone("(111) 111-1111");
//						c.setAddress("Address no. " + i);

						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
