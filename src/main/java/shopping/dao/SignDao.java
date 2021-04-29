package shopping.dao;

import shopping.dto.Sign;

public interface SignDao {

//	List<Sign> selectSignByAll();
//	Sign selectSignByNo(Sign sign);
	
	int insertSign(Sign sign);
	
	Sign LoginSign(Sign sign);	
}
