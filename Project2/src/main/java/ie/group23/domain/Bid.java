package ie.group23.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bidID;

	@Column(nullable=false)
	private double bidAmount;
	@Column(nullable=false)
	int jobID;
	@Column(nullable=false)
	int userID;
	
	public Bid(double bidAmount, int jobID, int userID) {
		super();
		this.bidAmount = bidAmount;
		this.jobID = jobID;
		this.userID = userID;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Bid [bidID=" + bidID + ", bidAmount=" + bidAmount + ", jobID=" + jobID + ", userID=" + userID + "]");
		
		return s.toString();
	}
}
