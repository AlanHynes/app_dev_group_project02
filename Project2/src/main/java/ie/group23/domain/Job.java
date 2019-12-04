package ie.group23.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Job {

	@Id
	@GeneratedValue
	private int jobID;

	@Column(nullable=false, unique=true)
	private String jobname;
	@Column(nullable=false)
	private String jobDesc;
	@Column(nullable=false)
	private String jobDate;
	
	public Job(String jobname, String jobDesc, String jobDate) {
		super();
		this.jobname = jobname;
		this.jobDesc = jobDesc;
		this.jobDate = jobDate;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Job [jobID=" + jobID + ", jobname=" + jobname + ", jobDesc=" + jobDesc + ", jobDate=" + jobDate + "]");
	
		return s.toString();
	}
	
}
