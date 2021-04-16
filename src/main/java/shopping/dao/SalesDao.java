package shopping.dao;

import java.util.List;

import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;

public interface SalesDao {
	//MAIN
	List<Sales> selectMain();	
	List<Sales> selectMainByDate(Sales sales);
	
	//PRODUCT
	List<Sales> selectProduct();
	List<Sales> selectProductByProInfo(Product product);
	
	//DETAIL
	List<Sales> selectDetail();
	
	//이름별 검색 고객
	
	List<Sales> selectDetailByProductAndCustoemr(Customer customer, Product product);
	
	
	
	int insertSales(Sales sales);
	int updateSales(Sales sales);
	int deleteSales(Sales sales);
	
	

}
