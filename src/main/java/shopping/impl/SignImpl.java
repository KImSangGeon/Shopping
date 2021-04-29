package shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dao.SignDao;
import shopping.dto.Sign;
import shopping.util.JdbcConn;

public class SignImpl implements SignDao {
	
	private static final SignImpl instance = new SignImpl();
	
	public static SignImpl getInstance(){
		return instance;
	}
	@Override
	public int insertSign(Sign sign) {
		String sql = "insert into sign_in values(?, password(?), ?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
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



	@Override
	public Sign LoginSign(Sign sign) {
		String sql = "select ID, password, name, birth, sex, phone"
				+ " from sign_in si where id = ? and password = password(?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, sign.getId());
			pstmt.setString(2, sign.getPasswd());
			try(ResultSet rs =  pstmt.executeQuery()){
				if(rs.next()) {
					return getSign(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



	private Sign getSign(ResultSet rs) throws SQLException {
		String id = rs.getString("ID");
		String passwd = rs.getString("password");
		String name = rs.getString("name");
		String birth = rs.getString("birth");
		String sex = rs.getString("sex");
		String phone = rs.getString("phone");		
		return new Sign(id, passwd, name, birth, sex, phone);
	}

}
