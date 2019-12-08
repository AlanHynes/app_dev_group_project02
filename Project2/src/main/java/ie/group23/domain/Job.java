package ie.group23.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private LocalDate localDate;
	
	@ManyToOne()
    private Users user;
	
//	@Column(columnDefinition = "default false")
//	private boolean isClosed;
	
//	public Job(String jobname, String jobDesc, LocalDate localDate, Users user, boolean isClosed) {
	public Job(String jobname, String jobDesc, LocalDate localDate, Users user) {
		super();
		this.jobname = jobname;
		this.jobDesc = jobDesc;
		this.localDate = localDate;
		this.user = user;
//		this.isClosed = isClosed;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Job [jobID=" + jobID + ", jobname=" + jobname + ", jobDesc=" + jobDesc + ", localDate=" + localDate + "]");
	
		return s.toString();
	}
	
}
