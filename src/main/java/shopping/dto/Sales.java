package shopping.dto;

public class Sales {
	
	private int orderNo;
	private String date;
	private int orderNum;
	private Customer cuNo;
	private Product pCode;
	private int saleAmount;
	private int profit;
	private int customerPrice;
	
	public String toStringP2() {//product 상세
		return String.format("%s, %s, %s, %s, %s, %s",
				orderNo, pCode.getpCode(), pCode.getpName(), orderNum, pCode.getPrice(), customerPrice);
		
	}
	public String toStringP() {//product
		return String.format(
				"%s, %s, %s, %s, %s, %s, %s, %s",				
				date, cuNo.getCuNo(), pCode.getpCode(), pCode.getpName(), orderNum, pCode.getPrice(), saleAmount, profit);
	}
	
	public String toStringD() {//Detail
		return String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s %s %s", 
				date, orderNo, pCode.getpCode(), pCode.getpName(), cuNo.getId(), cuNo.getCuNo(), cuNo.getCuName(), orderNum, pCode.getPrice(), saleAmount, profit);
	}

	public Sales(int orderNo) {
		this.orderNo = orderNo;
	}
	public Sales(String date, int saleAmount) {
		this.date = date;
		this.saleAmount = saleAmount;		
	}


	public Sales(int orderNo, String date, int orderNum, Customer cuNo, Product pCode, int saleAmount, int profit,
			int customerPrice) {
		this.orderNo = orderNo;
		this.date = date;
		this.orderNum = orderNum;
		this.cuNo = cuNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
		this.profit = profit;
		this.customerPrice = customerPrice;
	}
	
	public Sales(int orderNo, String date, int orderNum, Customer cuNo, Product pCode, int saleAmount, 
			int profit) {
		this.orderNo = orderNo;
		this.date = date;
		this.orderNum = orderNum;
		this.cuNo = cuNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
		this.profit = profit;
	}


	public Sales(String date, Customer cuNo, Product pCode, int saleAmount,  int profit) {
		this.date = date;
		this.cuNo = cuNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
		this.profit = profit;
	}

	public Sales(String date, Customer cuNo, Product pCode) {
		this.date = date;
		this.cuNo = cuNo;
		this.pCode = pCode;
	}


	public Sales(String date, Customer cuNo, Product pCode, int saleAmount) {
		this.date = date;
		this.cuNo = cuNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
	}


	public Sales(String date, int orderNo, int orderNum, Customer cuNo, Product pCode, int saleAmount) {		
		this.date = date;
		this.orderNo = orderNo;
		this.orderNum = orderNum;
		this.cuNo = cuNo;
		this.pCode = pCode;
		this.saleAmount = saleAmount;
	}

	
	public Sales(String date) {
		this.date = date;
	}

	
	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getOrderNum() {
		return orderNum;
	}
	
	public int getCustomerPrice() {
		return customerPrice;
	}
	public void setCustomerPrice(int customerPrice) {
		this.customerPrice = customerPrice;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public Customer getCuNo() {
		return cuNo;
	}


	public void setCuNo(Customer cuNo) {
		this.cuNo = cuNo;
	}


	public Product getpCode() {
		return pCode;
	}


	public void setpCode(Product pCode) {
		this.pCode = pCode;
	}


	public int getSaleAmount() {
		return saleAmount;
	}


	public Sales(Product pCode) {
		this.pCode = pCode;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}


	public int getProfit() {
		return profit;
	}


	public void setProfit(int profit) {
		this.profit = profit;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sales other = (Sales) obj;
		if (orderNo != other.orderNo)
			return false;
		return true;
	}
	@Override
	public String toString() {//main
		return String.format(
				"%s, %s, %s, %s, %s, %s, %s, %s, %s",				
				date, orderNo, cuNo.getId(), cuNo.getCuNo(), cuNo.getCuName(), cuNo.getPhone(), pCode.getpCode(), orderNum, saleAmount);
	}
	
		
}
