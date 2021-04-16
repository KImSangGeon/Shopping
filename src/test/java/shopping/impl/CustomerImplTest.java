package shopping.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shopping.dao.CustomerDao;
import shopping.dto.Customer;
import shopping.dto.Sign;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerImplTest {
	
	private static CustomerDao dao = CustomerImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectByCustomerByAll() {
		System.out.printf("%s()%n", "testSelectByCustomerByAll");
		List<Customer> customerList = dao.selectByCustomerByAll();
		Assert.assertNotNull(customerList);
		for(Customer c : customerList) {
			System.out.println(c);
		}
		
	}

	@Test
	public void test04SelectCustomerByNo() {
		System.out.printf("%s()%n", "testSelectCustomerByNo");
		Customer customer = new Customer(12001);
		Customer searhCustomer = dao.selectCustomerByNo(customer);
		Assert.assertNotNull(searhCustomer);
		System.out.println(searhCustomer);

	}

	@Test
	public void test02InsertCustomer() {
		System.out.printf("%s()%n", "testInsertCustomer");
		Customer newCu = new Customer(12008, "김미지", "1988-08-08", "010-3321-1920", "여자", new Sign("hhhh"));
		int res = dao.insertCustomer(newCu);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectCustomerByNo(newCu));
	}

	@Test
	public void test03DeleteCustomer() {
		System.out.printf("%s()%n", "test03DeleteCustomer");
		Customer delCu = new Customer(12008);
		int res = dao.deleteCustomer(delCu);		
		Assert.assertEquals(1, res);
		dao.selectByCustomerByAll().stream().forEach(System.out::println);
		
	}

}
