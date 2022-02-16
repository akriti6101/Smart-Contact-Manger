package spring.album.all.data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@NotBlank(message="No blank values allowed")
	@Size(min=3,max=12,message="Characters must be between 3-12")
	private String username;
	
	@Pattern(regexp="[A-Z a-z][A-Z a-z 0-9 @ /.]+",message="first character must be an alphabet")
	@Size(min=5,message="password must be atleast 5 char long.")
	private String password;
	public User() {
		super();
		
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
