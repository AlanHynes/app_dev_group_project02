package ie.group23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.group23.dao.JobDAO;
import ie.group23.domain.Job;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobServiceImplementation implements JobService{

	@Autowired
	JobDAO jobDAO;
	
	@Override
	public Job findJob(int jobID) {
		if (jobDAO.existsById(jobID))
			return jobDAO.findById(jobID).get();
		return null;
	}

	@Override
	public Job findByJobName(String jobname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job save(Job job) {
		return jobDAO.save(job);
	}
	
	@Override
	public List<Job> listInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
