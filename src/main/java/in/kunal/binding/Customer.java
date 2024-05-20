package in.kunal.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	private String uname;
	private String pwd;
	private String phone;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "Customer [cId=" + cId + ", uname=" + uname + ", pwd=" + pwd + ", phone=" + phone + "]";
	}

}
