package shopping.dto;

public class Product {
	
	private String pCode;
	private String pName;
	private int price;
	private int stock;
	

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
// 코드 이중양택 
	@Override
	public String toString() {
		String str="";
		if(pCode != null) {
			str = pCode;			
		}else {
			str = pName;			
		}		
		return String.format("%s", str);
		
		
		
//		return String.format("%s %s", pCode == null ? "" : pCode, pName == null ? "" : pName );
	}
		
}
