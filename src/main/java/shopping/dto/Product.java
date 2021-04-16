package shopping.dto;

public class Product {
	
	private String pCode;
	private String pName;
	private int price;
	private int stock;
	
	public Product() {
		super();
	}
	

	public Product(String pCode) {
		this.pCode = pCode;
	}


	public Product(String pCode, String pName, int price, int stock) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.stock = stock;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return String.format("%s", pCode);
	}
	
	
	
	
	
}
