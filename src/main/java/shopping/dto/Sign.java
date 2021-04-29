package shopping.dto;

public class Sign {
	
	private String id;
	private String passwd;
	private String name;
	private String birth;
	private String sex;
	private String phone;

	public Sign() {}

	public Sign(String id) {
		this.id = id;
	}

	public Sign(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public Sign(String id, String passwd, String name, String birth, String sex, String phone) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.birth = birth;
		this.sex = sex;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("%s", id); 
	}
	
	
	
	
	
	
	
}
