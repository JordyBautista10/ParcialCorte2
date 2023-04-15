package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			System.out.println("\nVerificando borrado de empleados....");

			employeeService.deleteEmployees();

			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));

			System.out.println("Adding employees....\n");
			employeeService.addEmployee(new Employee("Jordy", "Bautista", "Estudiante", 00001.00, LocalDate.of(2002, 12, 10)));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Profesor", 43000.00, LocalDate.of(1992, 01, 06)));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee.getAge()));


		};
	}

}
