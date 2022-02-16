package spring.album.all.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Contact {

	
	
	 
	 
	private String userAccountName;

	@Size(min=3,max=12,message="Name should be 3-12 length long")
	@Pattern(regexp="[A-Z a-z]{2}[A-Z a-z 0-9 ' ']*",message="Name is invalid")
	private String name;
	
	private String work;
	
	 @Id
	@NotBlank(message="Contact Number should not be blank")
	@Pattern(regexp="[7-9][0-9]{9}",message="Contact Number is invalid")
	private String phone;
	
	@Pattern( regexp="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+",message="Invalid Email Address")
	private String email;
	
	private String filename;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Contact(String userAccountName, String name, String work, String phone, String email) {
		super();
		this.userAccountName = userAccountName;
		this.name = name;
		this.work = work;
		this.phone = phone;
		this.email = email;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserAccountName() {
		return userAccountName;
	}
	public void setUserAccountName(String userAccountName) {
		this.userAccountName = userAccountName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [userAccountName=" + userAccountName + ", name=" + name + ", work=" + work + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
}
