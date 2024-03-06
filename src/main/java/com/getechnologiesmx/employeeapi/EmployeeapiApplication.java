package com.getechnologiesmx.employeeapi;

import com.getechnologiesmx.employeeapi.entity.Employee;
import com.getechnologiesmx.employeeapi.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeRepository employeeRepository){
		return (String... args) -> {
			List<Employee> employees = Arrays.asList(
					new Employee("Juan", LocalDate.now(), 24, 1, true),
					new Employee("Enrique", LocalDate.now(), 24, 1, true),
					new Employee("Angel", LocalDate.now(), 24, 2, false),
					new Employee("Gerardo", LocalDate.now(), 25, 3, true),
					new Employee("Francisco", LocalDate.now(), 26, 1, true)
			);

			employeeRepository.saveAll(employees);
		};
	}

}
