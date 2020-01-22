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
					.deleteAll()
					.subscribe(null, null, () -> {
						() -> Stream.of(
								new Employee(UUID.randomUUID().toString(), "Ram", 1500000),
								new Employee(UUID.randomUUID().toString(), "Jaya", 1400000),
								new Employee(UUID.randomUUID().toString(), "Bhanu", 1300000),
								new Employee(UUID.randomUUID().toString(), "Dev", 1200000)
						).forEach(employee -> {
							employeeRepository.save(employee)
									.subscribe(System.out::println);
						});



					});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}

}
