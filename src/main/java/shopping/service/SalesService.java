package shopping.service;

import java.util.List;

import shopping.dao.SalesDao;
import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.impl.SalesImpl;

public class SalesService {
	
	private SalesDao dao = SalesImpl.getInstance();	

	public List<Sales>showMainList(){
		return dao.selectMain();
	}
	
	public List<Sales>showProdcutList(){
		return dao.selectProduct();
	}
	
	public List<Sales>showDetailList(){
		return dao.selectDetail();
	}
	public List<Sales> selectByDate(Sales sales){
		return dao.selectMainByDate(sales);
	}
	public List<Sales> selectByPcode(Product product){
		return dao.selectProductByPcode(product);
	}
	public List<Sales> selectByPname(String pName){
		return dao.selectProductByPname(pName);			
	}
	public List<Sales> selectByCname(String cuName){
		return dao.selectDetailByCname(cuName);
	}
	
	public List<Sales> selectByPnameAndCname(String pName, String cuName){
		return dao.selectDetailByProductAndCustoemr(pName, cuName);
	}

	
}
