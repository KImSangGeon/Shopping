package shopping.impl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.util.JdbcConn;

public class SalesImplTest {
	
	private SalesImpl dao;
//	private static Connection con;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		con = JdbcConn.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		dao = SalesImpl.getInstance();
//		dao.setCon(con);
	}


	@Test
	public void testSelectMain() {
		System.out.printf("%s()%n", "testSelectMain");
		List<Sales> salesList = dao.selectMain();
		Assert.assertNotNull(salesList);
		for(Sales s : salesList) {
			System.out.println(s);
		}
	}

	@Test
	public void testSelectMainByDate() {
		System.out.printf("%s()%n", "testSelectMainByDate");
		Sales sales = new Sales("2012-04-14");
		List<Sales> list = dao.selectMainByDate(sales);
		Assert.assertNotNull(list);
		for(Sales s : list) {
			System.out.println(s);
		}
	}

	@Test
	public void testSelectProduct() {
		System.out.printf("%s()%n", "testSelectProduct");
		List<Sales> salesList = dao.selectProduct();
		Assert.assertNotNull(salesList);
		for(Sales s : salesList) {
			System.out.println(s.toStringP());
		}
	}

	@Test
	public void testSelectProductByPcode() {
		System.out.printf("%s()%n", "testSelectProductByPcode");
		List<Sales> list = dao.selectProductByPcode(new Product("PA"));
		Assert.assertNotNull(list);
		for(Sales s : list) {
			System.out.println(s.toStringP());
		}
	}
	
	@Test
	public void testSelectProductByPname() {
		System.out.printf("%s()%n", "testSelectProductByPname");
		List<Sales> list = dao.selectProductByPname("자전거");
		Assert.assertNotNull(list);
		for(Sales s : list) {
			System.out.println(s.toStringP());
		}
	}
	@Test
	public void testSelectProductByCname() {
		System.out.printf("%s()%n", "testSelectProductByCname");
		List<Sales> list = dao.selectDetailByCname("홍길동");
		Assert.assertNotNull(list);
		for(Sales s : list) {
			System.out.println(s.toStringP());
		}
	}

	@Test
	public void testSelectDetail() {
		System.out.printf("%s()%n", "testSelectDetail");
		List<Sales> detailList = dao.selectDetail();
		Assert.assertNotNull(detailList);
		for(Sales s : detailList) {
			System.out.println(s.toStringD());
		}
	}


	@Test
	public void testSelectDetailByProductAndCustoemr() {
		System.out.printf("%s()%n", "testSelectDetailByProductAndCustoemr");
		List<Sales> list = dao.selectDetailByProductAndCustoemr("냉장고", "홍길동");
		Assert.assertNotNull(list);
		for(Sales s : list) {
			System.out.println(s.toStringD());
		}
	}

	@Test
	public void testInsertSales() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSales() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSales() {
		fail("Not yet implemented");
	}

}
