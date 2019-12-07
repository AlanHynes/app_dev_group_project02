package ie.group23.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String phoneNum;

	//@OneToOne
	//@JoinColumn(name="roleEmail",nullable = false)
	@Column(nullable=false)
	String userRole;

	@Column
	boolean userEnabled;

	public Users(String name, String email, String password, String phoneNum, String userRole, boolean userEnabled) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.userRole = userRole;
		this.userEnabled = userEnabled;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Users [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNum=" + phoneNum + ", userRole=" + userRole + ", userEnabled=" + userEnabled + "]");
		return s.toString();
	}
	


}
