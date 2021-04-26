package shopping.impl;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shopping.dto.Sign;
import shopping.util.JdbcConn;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignImplTest {
	
	private SignImpl dao;
	private static Connection con;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcConn.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		dao = SignImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void test01InsertSign() {
		System.out.printf("%s()%n", "testInsertSign");
		Sign newSign = new Sign("iiii", "iiii12", "김상일", "1987-06-04", "남자", "010-3302-1992");
		int res = dao.insertSign(newSign);
		Assert.assertEquals(1, res);
	}

}
