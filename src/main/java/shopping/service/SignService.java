package shopping.service;

import shopping.dao.SignDao;
import shopping.dto.Sign;
import shopping.impl.SignImpl;

public class SignService {
	
	private SignDao dao = SignImpl.getInstance(); 
	
	public void insertCustomer(Sign sign) {
		dao.insertSign(sign);
	}

}
