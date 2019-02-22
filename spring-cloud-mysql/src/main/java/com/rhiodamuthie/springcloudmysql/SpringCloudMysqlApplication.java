package com.rhiodamuthie.springcloudmysql;

import com.rhiodamuthie.springcloudmysql.model.Contact;
import com.rhiodamuthie.springcloudmysql.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringCloudMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMysqlApplication.class, args);
	}


//	Initialize data to db
	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 100)
					.mapToObj(i -> {
						Contact c = new Contact();
						c.setName("Contact " + i);
						c.setEmail("contact" + i + "@email.com");
						c.setPhone("(111) 111-1111");
						c.setAddress("Address no. " + i);

						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
