package ie.group23.formobjects;

import javax.validation.constraints.NotNull;

import ie.group23.domain.Job;
import ie.group23.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BidForm {
	@NotNull
	private int bidID;

	private double bidAmount;
	private Job job;
	private Users user;
}
