package shopping.dao;

import java.util.List;

import shopping.dto.Customer;

public interface CustomerDao {
	
	List<Customer> selectByCustomerByAll();
	//콤보박스 뛰우기용 
	List<Customer> selectByName();
	Customer selectCustomerByNo(Customer customer);
	
	
	int insertCustomer(Customer customer);
	int deleteCustomer(Customer customer);
	
}
