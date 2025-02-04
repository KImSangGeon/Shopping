package shopping.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shopping.dto.Product;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImplTest {
	
	private ProductImpl dao;
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
		dao = ProductImpl.getInstance();
//		dao.setCon(con);
	}

	@Test
	public void test04SelectProductByAll() {
		System.out.printf("%s()%n", "testSelectProductByAll");
		List<Product> productList = dao.selectProductByAll();
		Assert.assertNotNull(productList);
		
		for(Product p : productList) {
			System.out.println(p.ProductInfo());
		}
	}
	@Test
	public void test06SelectPcode() {
		System.out.printf("%s()%n", "test06SelectPcode");
		List<Product> produList = dao.selectPcode();
		Assert.assertNotNull(produList);
		
		for(Product p : produList) {
			System.out.println(p);
		}
		
	}
	
	@Test
	public void test07SelectPname() {
		System.out.printf("%s()%n", "test07SelectPname");
		List<Product> produList = dao.selectPname();
		Assert.assertNotNull(produList);
		
		for(Product p : produList) {
			System.out.println(p);
		}
		
	}
	
	@Test
	public void test05SelectProductByNo() {
		System.out.printf("%s()%n", "testSelectProductByNo");
		Product	product = new Product("PB");
		Product searchProduct = dao.selectByProInfo(product);
		Assert.assertNotNull(searchProduct);
		System.out.println(searchProduct);
	}

	@Test
	public void test01InsertProduct() {
		System.out.printf("%s()%n", "testInsertProduct");
		Product newProduct = new Product("PI", "드론", 3000000, 4, getImage("NoImage.jpg"));
		int res = dao.insertProduct(newProduct);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectByProInfo(newProduct));

	}

	private byte[] getImage(String imgName) {
		byte[] pic = null;
		// images/imgName
		File file = new File(System.getProperty("user.dir") + File.separator + "images", imgName);
		try(InputStream is = new FileInputStream(file)){
			pic = new byte[is.available()];   //file로 부터 읽은 이미지의 바이트길이로 배열 생성
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
	@Test
	public void test02UpdateProduct() {
		System.out.printf("%s()%n", "testUpdateProduct");
		Product	modifyProduct = new Product("PI", "킥보드", 50000, 5);
		int res = dao.updateProduct(modifyProduct);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectByProInfo(modifyProduct));
	}

	@Test
	public void test03DeleteProduct() {
		System.out.printf("%s()%n", "DeleteProduct");
		int res = dao.deleteProduct(new Product("PI"));
		Assert.assertEquals(1, res);
		List<Product> ProductList = dao.selectProductByAll();

		for(Product p : ProductList) {
			System.out.println(p);
		}
		
	}

}
