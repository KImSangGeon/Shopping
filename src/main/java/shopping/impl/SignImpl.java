package shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shopping.dao.SignDao;
import shopping.dto.Sign;
import shopping.util.JdbcConn;

public class SignImpl implements SignDao {
	
	private static final SignImpl instance =new SignImpl();
	private Connection con;
	
	public static SignImpl getInstance(){
		return instance;
	}
	
	

	public void setCon(Connection con) {
		this.con = con;
	}



	@Override
	public int insertSign(Sign sign) {
		String sql = "insert into sign_in values(?, password(?), ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, sign.getId());
			pstmt.setString(2, sign.getPasswd());
			pstmt.setString(3, sign.getName());
			pstmt.setString(4, sign.getBirth());
			pstmt.setString(5, sign.getSex());
			pstmt.setString(6, sign.getPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
