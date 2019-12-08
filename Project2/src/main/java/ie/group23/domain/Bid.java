package ie.group23.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.RestResource;

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
//	@Column(nullable=false)
//	int jobID;
//	@Column(nullable=false)
//	int userID;
	
	@ManyToOne
//    @JoinColumn(name = "jobID")
//    @RestResource(path = "Bidjob", rel="job")
    private Job job;
	
	@ManyToOne
//    @JoinColumn(name = "userID")
//    @RestResource(path = "Biduser", rel="user")
    private Users user;

	public Bid(double bidAmount, Users user, Job job) {
		super();
		this.bidAmount = bidAmount;
		this.job = job;
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Bid [bidID=" + bidID + ", bidAmount=" + bidAmount + ", jobID=" + job + ", userID=" + user + "]");
		
		return s.toString();
	}
}
