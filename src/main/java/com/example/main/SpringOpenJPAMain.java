package com.example.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;

public class SpringOpenJPAMain {
	
	
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee-servlet.xml");
		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");
		
		Employee employee1 = new Employee();
		employee1.setFirstname("Neil");
		employee1.setLastname("Mukesh");
		dao.addEmployee(employee1);
		System.out.println("--------Added--------");
		
		List<Employee> emplist = dao.getAllEmployees();
		for(Employee entry : emplist){
			System.out.println(entry.getFirstname());
			System.out.println(entry.getLastname());
			System.out.println(entry.getId());
		}
		
		//dao.deleteEmployee(1);
	}

}
