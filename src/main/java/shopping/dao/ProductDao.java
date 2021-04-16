package shopping.dao;

import java.util.List;

import shopping.dto.Product;

public interface ProductDao {
	
	List<Product> selectProductByAll();
	//코드별 검색
	List<Product> selectPcode();
	
	//제품별 검색
	List<Product> selectPname();
	
	
	Product selectByProInfo(Product product);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(Product product);
	

}
