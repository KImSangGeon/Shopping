package shopping.service;

import java.util.List;

import shopping.dao.CustomerDao;
import shopping.dto.Customer;
import shopping.dto.Sign;
import shopping.impl.CustomerImpl;

public class CustomerService {
	private CustomerDao dao = CustomerImpl.getInstance();
	
	public List<Customer> showCustomerView(){
		return dao.selectByCustomerByAll();		
	}
	public List<Customer> selectByName(){
		return dao.selectByName();
	}
	public void InsertCustomer(Customer customer) {
		dao.insertCustomer(customer);
	}
}
