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
	private LocalDate jobDate;
	
	public Job(int jobID, String jobname, String jobDesc, LocalDate jobDate) {
		super();
		this.jobID = jobID;
		this.jobname = jobname;
		this.jobDesc = jobDesc;
		this.jobDate = jobDate;
	}
	
}
