package shopping.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shopping.dao.ProductDao;
import shopping.dto.Product;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImplTest {
	
	private static ProductDao dao = ProductImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectProductByAll() {
		System.out.printf("%s()%n", "testSelectProductByAll");
		List<Product> productList = dao.selectProductByAll();
		Assert.assertNotNull(productList);
		
		for(Product p : productList) {
			System.out.println(p);
		}
	}

	@Test
	public void test05SelectProductByNo() {
		System.out.printf("%s()%n", "testSelectProductByNo");
		Product	product = new Product("PB");
		Product searchProduct = dao.selectProductByNo(product);
		Assert.assertNotNull(searchProduct);
		System.out.println(searchProduct);
	}

	@Test
	public void test01InsertProduct() {
		System.out.printf("%s()%n", "testInsertProduct");
		Product newProduct = new Product("PI", "드론", 3000000, 4);
		int res = dao.insertProduct(newProduct);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProductByNo(newProduct));

	}

	@Test
	public void test02UpdateProduct() {
		System.out.printf("%s()%n", "testUpdateProduct");
		Product	modifyProduct = new Product("PI", "킥보드", 50000, 5);
		int res = dao.updateProduct(modifyProduct);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProductByNo(modifyProduct));
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
