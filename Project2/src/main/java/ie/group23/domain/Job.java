package ie.group23.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobID;

	@Column(nullable=false, unique=true)
	private String jobname;
	@Column(nullable=false)
	private String jobDesc;
	@Column(nullable=false)
	private String jobDate;
	
	@ManyToOne()
    private Users user;
	
	public Job(String jobname, String jobDesc, String jobDate, Users user) {
		super();
		this.jobname = jobname;
		this.jobDesc = jobDesc;
		this.jobDate = jobDate;
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Job [jobID=" + jobID + ", jobname=" + jobname + ", jobDesc=" + jobDesc + ", jobDate=" + jobDate + "]");
	
		return s.toString();
	}
	
}
