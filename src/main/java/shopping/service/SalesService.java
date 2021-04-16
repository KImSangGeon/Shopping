package shopping.service;

import java.util.List;

import shopping.dao.SalesDao;
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
}
