package shopping.dto;

public class Customer {
	
	private int cuNo;
	private String cuName;
	private Sign id;
	private String birth;
	private String phone;
	private String sex;
	
	
	public Customer() {}


	public Customer(int cuNo) {
		this.cuNo = cuNo;
	}


	public Customer(Sign id, String cuName, String birth, String sex,  String phone) {
		this.id = id;
		this.cuName = cuName;		
		this.birth = birth;		
		this.sex = sex;
		this.phone = phone;		
	}


	public Customer(int cuNo, String cuName, String birth, String phone, String sex, Sign id) {
		this.cuNo = cuNo;
		this.cuName = cuName;		
		this.birth = birth;
		this.phone = phone;
		this.sex = sex;
		this.id = id;
	}



	public int getCuNo() {
		return cuNo;
	}


	public void setCuNo(int cuNo) {
		this.cuNo = cuNo;
	}


	public String getCuName() {
		return cuName;
	}


	public void setCuName(String cuName) {
		this.cuName = cuName;
	}


	public Sign getId() {
		return id;
	}


	public void setId(Sign id) {
		this.id = id;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}



	@Override
	public String toString() {
		return String.format("%s", cuName);
	}


	
	
	
}
