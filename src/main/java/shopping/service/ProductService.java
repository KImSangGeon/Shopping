package shopping.service;

import java.util.List;

import shopping.dao.ProductDao;
import shopping.dto.Product;
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

}
