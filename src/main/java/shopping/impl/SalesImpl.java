package shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import shopping.dao.SalesDao;
import shopping.dto.Customer;
import shopping.dto.Product;
import shopping.dto.Sales;
import shopping.dto.Sign;
import shopping.util.JdbcConn;

public class SalesImpl implements SalesDao {

	private static SalesImpl instance = new SalesImpl();

	public static SalesImpl getInstance() {
		return instance;
	}

	private Sales getSale(ResultSet rs) {
		int orderNo = 0;
		String date = null;
		int orderNum = 0;
		Customer cuNo = null;
		Product pCode = null;
		int saleAmount = 0;
		int profit = 0;
		int customerPrice = 0;
		String phone = null;
//		 p_name, ID, cu_name, price, Total_Sales, Profit_Cost

		try {
			pCode = new Product(rs.getString("p_code"));
		} catch (SQLException e3) {
		}
		try {
			orderNum = rs.getInt("order_num");
		} catch (SQLException e2) {
		}

		try {
			date = rs.getString("date");
		} catch (SQLException e1) {
		}
		try {
			cuNo = new Customer(rs.getInt("cu_no"));
		} catch (SQLException e) {
		}

		try {
			orderNo = rs.getInt("order_no");
		} catch (SQLException e) {
		}

		try {
			pCode.setpName(rs.getString("p_name"));
		} catch (SQLException e) {
		}

		try {
			pCode.setStock(rs.getInt("stock"));
		} catch (SQLException e3) {
		}
		try {
			cuNo.setPhone(rs.getString("phone"));
		} catch (SQLException e) {
		}

		try {
			cuNo.setId(new Sign(rs.getString("ID")));
		} catch (SQLException e) {
		}

		try {
			cuNo.setCuName(rs.getString("cu_name"));
		} catch (SQLException e) {
		}

		try {
			pCode.setPrice(rs.getInt("price"));
		} catch (SQLException e) {
		}

		try {
			saleAmount = rs.getInt("Total_Sales");
		} catch (SQLException e) {
		}

		try {
			profit = rs.getInt("Profit_Cost");
		} catch (SQLException e) {
		}

		try {
			customerPrice = rs.getInt("Customer_Price");

		} catch (SQLException e) {
		}

		return new Sales(orderNo, date, orderNum, cuNo, pCode, saleAmount, profit, customerPrice);

	}

	@Override
	public List<Sales> selectMain() {
		String sql = "select date, order_no, ID, cu_no, cu_name, phone,"
				+ "	p_code, order_num, Total_Sales from vw_shoppingmall";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Sales> list = new ArrayList<Sales>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectMainByDate(Sales sales) {
		String sql = "select date, order_no, ID, cu_no, cu_name," 
				+ " phone, p_code, order_num, Total_Sales "
				+ "	from vw_shoppingmall where date = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, sales.getDate());
			try (ResultSet rs = pstmt.executeQuery()) {
				ArrayList<Sales> list = new ArrayList<Sales>();
				if (rs.next()) {
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectProductAddTotalPrice(String id) {
		String sql = "select order_no, cu_no, p_code, p_name, order_num, price, Customer_Price "
				+ "from vw_shoppingmall where id = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				ArrayList<Sales> list = new ArrayList<Sales>();
				if(rs.next()) {
					do {
						list.add(getSale(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectProduct() {
		String sql = "select  date, cu_no, p_code, p_name, order_num, price, "
				+ "Total_Sales, Profit_Cost from vw_shoppingmall";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Sales> list = new ArrayList<Sales>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectProductByPcode(Product product) {
		String sql = "select date, cu_no, p_code, p_name, order_num," + " price, Total_Sales, Profit_Cost "
				+ "	from vw_shoppingmall where p_code = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, product.getpCode());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Sales> list = new ArrayList<Sales>();
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectProductByPname(String pName) {
		String sql = "select date, order_no, p_code, p_name," + " id, cu_no, cu_name, order_num, "
				+ "	price, Total_Sales, Profit_Cost " + "	from vw_shoppingmall where p_name =  ? ";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Sales> list = new ArrayList<Sales>();
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectDetailByCname(String cuName) {
		String sql = " select date, order_no, p_code, p_name, " + "	id, cu_no, cu_name, order_num, "
				+ "	price, Total_Sales, Profit_Cost from" + " vw_shoppingmall where cu_name = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, cuName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Sales> list = new ArrayList<Sales>();
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Sales> selectDetailByProductAndCustoemr(String pName, String cuName) {
		String sql = "select date, order_no, p_code, p_name,"
				+ "	id, cu_no, cu_name, order_num, "
				+ "	price, Total_Sales, Profit_Cost " 
				+ " from vw_shoppingmall where p_name =? and cu_name = ? ";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, pName);
			pstmt.setString(2, cuName);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Sales> list = new ArrayList<Sales>();
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sales> selectDetail() {
		String sql = "select date, order_no, p_code, p_name, ID," 
				+ " cu_no, cu_name, order_num, price, "
				+ "	Total_Sales, Profit_Cost" 
				+ " from vw_shoppingmall";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Sales> list = new ArrayList<Sales>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertSales(Sales sales) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSales(Sales sales) {
		return 0;
	}

	@Override
	public int deleteSales(Sales sales) {
		String sql = "delete from sales_information where order_no = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sales.getOrderNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertByOrder(Sales sale) {
		String sql="insert into sales_information (date, order_num, cu_no, p_code) values"
				+  " (now(), ?, ?,? )";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sale.getOrderNum());
			pstmt.setInt(2, sale.getCuNo().getCuNo());
			pstmt.setString(3, sale.getpCode().getpCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
