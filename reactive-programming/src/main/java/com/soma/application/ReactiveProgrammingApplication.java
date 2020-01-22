package com.soma.application;

import com.soma.application.entity.Employee;
import com.soma.application.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveProgrammingApplication {

	@Bean
	public CommandLineRunner employee(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository
					.deleteAll()	// For cleanup the data
					.subscribe(null, null, () -> {
						Stream.of(
								new Employee(UUID.randomUUID().toString(), "Name 1", new Double("1000000.00")),
								new Employee(UUID.randomUUID().toString(), "Name 2", 900000.00),
								new Employee(UUID.randomUUID().toString(), "Name 3", 800000.00),
								new Employee(UUID.randomUUID().toString(), "Name 4", 700000.00)
						).forEach(employee -> {
							employeeRepository.save(employee).subscribe(System.out::println);
						});
					});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}

}
