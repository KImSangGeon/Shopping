package shopping.dao;

import java.util.List;

import shopping.dto.Product;

public interface ProductDao {
	
	List<Product> selectProductByAll();
	Product selectProductByNo(Product product);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(Product product);
	

}
