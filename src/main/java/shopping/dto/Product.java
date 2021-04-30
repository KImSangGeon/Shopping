package shopping.dto;

public class Product {
	
	private String pCode;
	private String pName;
	private int price;
	private int stock;
	private byte[] proPic;
	

	public Product() {
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


	public Product(String pCode, String pName, int price, int stock, byte[] proPic) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.stock = stock;
		this.proPic = proPic;
	}


	public byte[] getProPic() {
		return proPic;
	}


	public void setProPic(byte[] proPic) {
		this.proPic = proPic;
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
	
	public String ProductInfo() {
		return String.format("%s, %s, %s, %s", pCode, pName, price, stock);
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pCode == null) ? 0 : pCode.hashCode());
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
		Product other = (Product) obj;
		if (pCode == null) {
			if (other.pCode != null)
				return false;
		} else if (!pCode.equals(other.pCode))
			return false;
		return true;
	}


		
}
