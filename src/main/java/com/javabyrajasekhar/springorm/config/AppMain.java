package com.javabyrajasekhar.springorm.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabyrajasekhar.springorm.entity.Customer;
import com.javabyrajasekhar.springorm.service.CustomerService;
public class AppMain {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerService customerService = context.getBean(CustomerService.class);
		Customer customer1 = new Customer();
		customer1.setEmail("xyz@gmail.com");
		customer1.setFirstName("busireddy");
		customer1.setLastName("reddy");
		customerService.saveCustomer(customer1);
		
		
		System.out.println("------------------------------------get---------------------");
		Customer customer = customerService.getCustomer(2);
		System.out.println("id :-  "+customer.getId());
		System.out.println("firstname :-  "+customer.getFirstName());
		System.out.println("lastname :-  "+customer.getLastName());
		System.out.println("email :-  "+customer.getEmail());
		
		System.out.println("------------------------------------end get-----------");
	List<Customer> customers = customerService.getCustomers();
	for (Customer customer2 : customers) {
		System.out.println("id :-  "+customer2.getId());
		System.out.println("firstname :-  "+customer2.getFirstName());
		System.out.println("lastname :-  "+customer2.getLastName());
		System.out.println("email :-  "+customer2.getEmail());
		System.out.println("------------------------------------");
	}

	customerService.deleteCustomer(4);
		context.close();
	}
}
