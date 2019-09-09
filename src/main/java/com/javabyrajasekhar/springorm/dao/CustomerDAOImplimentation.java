package com.javabyrajasekhar.springorm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.javabyrajasekhar.springorm.entity.Customer;

@Repository
public class CustomerDAOImplimentation implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
Query query = entityManager.createQuery("select c from Customer c");
List list = query.getResultList();
		return list;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		entityManager.persist(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		return entityManager.find(Customer.class, theId);

	}

	@Override
	public void deleteCustomer(int theId) {
		Customer customer = entityManager.find(Customer.class, theId);
		if (null != customer) {
			entityManager.remove(customer);;
			System.out.println("deleted customer succesfully " + theId);
		} else {
			System.out.println(" customer not found - " + theId);
		}

	}

}
