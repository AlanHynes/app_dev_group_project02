package ie.group23.formobjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ie.group23.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
	@NotNull
	@Size(min=1, max=30)
	private String name;	
	
	private int userID;
	private String email;
	private String password;
	private String phoneNum;
	
	Role userRole;
	boolean userEnabled;
}