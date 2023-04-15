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
			employeeService.addEmployee(new Employee("Jorge", "Eseche", "Profesor", 43000.00, LocalDate.of(1995, 07, 06)));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee.getAge()));

			System.out.println("\nGetting employee with id = 1....");
			System.out.println(employeeService.getEmployee(1L));

			System.out.println("\nUpdating employee with id = 1....");
			System.out.println("Before----->" + employeeService.getEmployee(1L));
			Employee employee = employeeService.getEmployee(1L);
			employee.setFirstName("Marge");
			System.out.println("After------>" + employeeService.updateEmployee(employee));

			System.out.println("\nDeleting employee....");
			employeeService.deleteEmployee(1L);
		};
	}

}
