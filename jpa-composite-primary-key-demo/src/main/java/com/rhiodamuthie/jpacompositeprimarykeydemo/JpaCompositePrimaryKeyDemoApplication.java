package com.rhiodamuthie.jpacompositeprimarykeydemo;

import com.rhiodamuthie.jpacompositeprimarykeydemo.model.Employee;
import com.rhiodamuthie.jpacompositeprimarykeydemo.model.EmployeeIdentity;
import com.rhiodamuthie.jpacompositeprimarykeydemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCompositePrimaryKeyDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaCompositePrimaryKeyDemoApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	public void run(String... args) throws Exception {
		// Cleanup employees table
		employeeRepository.deleteAllInBatch();

		// Insert a new Employee in the database
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
				"Rhioda Muthie",
				"rhioda.m@gmail.com",
				"+62-1231244234");

		employeeRepository.save(employee);
	}
}
