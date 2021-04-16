package shopping.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shopping.dao.SignDao;
import shopping.dto.Sign;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignImplTest {
	
	private static SignDao dao = SignImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01InsertSign() {
		System.out.printf("%s()%n", "testInsertSign");
		Sign newSign = new Sign("hhhh", "hhhh12", "김수준", "1999-06-05", "남자", "010-3302-1982");
		int res = dao.insertSign(newSign);
		Assert.assertEquals(1, res);
	}

}
