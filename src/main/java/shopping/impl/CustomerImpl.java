package shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shopping.dao.CustomerDao;
import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.dto.Sign;
import shopping.util.JdbcConn;

public class CustomerImpl implements CustomerDao {
	
	private static final CustomerImpl instance = new CustomerImpl();
	
	public static CustomerImpl getInstance() {
		return instance;
	}

	@Override
	public List<Customer> selectByCustomerByAll() {
		String sql = "select cu_no, cu_name, birth, phone, sex, ID from customer_information";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Customer> list = new ArrayList<>();
				do {
					list.add(getCustomer(rs));
				}while(rs.next());
					return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Customer getCustomer(ResultSet rs) throws SQLException {
		int cuNo = rs.getInt("cu_no");
		String cuName = rs.getString("cu_name");
		String birth = rs.getString("birth");
		String phone = rs.getString("phone");
		String sex = rs.getString("sex");
		Sign id = new Sign(rs.getString("ID"));		
	
		return new Customer(cuNo, cuName, birth, phone, sex, id);
		
	}

	@Override
	public Customer selectCustomerByNo(Customer customer) {
		String sql = "select cu_no,cu_name,birth,phone,sex,ID from customer_information where cu_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, customer.getCuNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getCustomer(rs);
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCustomer(Customer customer) {
		String sql = "insert into customer_information values(?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, customer.getCuNo());
			pstmt.setString(2, customer.getCuName());
			pstmt.setString(3, customer.getBirth());
			pstmt.setString(4, customer.getPhone());
			pstmt.setString(5, customer.getSex());
			pstmt.setString(6, customer.getId().getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomer(Customer customer) {
		String sql = "delete from customer_information where cu_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, customer.getCuNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
