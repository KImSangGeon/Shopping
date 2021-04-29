package shopping.service;

import java.util.List;

import shopping.dao.ProductDao;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.impl.ProductImpl;

public class ProductService {
	
	private ProductDao dao = ProductImpl.getInstance();	
	
	public Product selectByProInfo(Product product) {
		return dao.selectByProInfo(product);
	}
	public List<Product> selectByPcode() {
		return dao.selectPcode();
	}
	public List<Product> selectByPname(){
		return dao.selectPname();		
	}

	public List<Product> selectByProductAll(){
		return dao.selectProductByAll();
	}
	
	public int insertProduct(Product product) {
		return dao.insertProduct(product);
	}
	

}
