package shopping.dao;

import java.util.List;

import shopping.dto.Customer;

public interface CustomerDao {
	
	List<Customer> selectByCustomerByAll();
	Customer selectCustomerByNo(Customer customer);
	
	int insertCustomer(Customer customer);
	int deleteCustomer(Customer customer);
	
}
