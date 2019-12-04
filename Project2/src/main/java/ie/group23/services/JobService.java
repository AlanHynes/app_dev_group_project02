package ie.group23.services;

import java.util.List;

import ie.group23.domain.Job;

public interface JobService {

	Job findJob(int jobID);
	//boolean deleteCounty(County county);
	//boolean deleteCounty(int id);
	Job findByJobName(String jobname);
	List<Job> listInAlphabeticalOrder(); 
	//String findCountyName(int id);
	//List<County> findCountiesWithTownName(String townName);
	Job save(Job user) ;
}
