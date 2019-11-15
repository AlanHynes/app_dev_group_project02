package ie.group23.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	
	@Column(nullable=false, unique=true)
	private String countyName;

//	@OneToMany(mappedBy="users", fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	// If the API gets a county, it will get a list of towns, which have counties, which have towns...and so on 
	// into an infinite loop.
	// So here we instruct the REST controller to ignore this list of towns when retrieving the data on the county/town.
	@JsonIgnore
    private List<Users> towns = new ArrayList<>();

	public Users(String name) {
		this.countyName = name;
	}

}
