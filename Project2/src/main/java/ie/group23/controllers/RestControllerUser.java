package ie.group23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.group23.domain.Job;
import ie.group23.domain.Users;
import ie.group23.services.JobService;
import ie.group23.services.UsersService;

@RestController	// All returned data is converted to Json format.
				// On the consumer side, this will be parameterised (mapped) to objects
@RequestMapping("/api")	// All endpoints start with localhost:8080/api
public class RestControllerUser {
	@Autowired
	UsersService usersService;
	
	@Autowired
	JobService jobService;
	
	
	@GetMapping("users")
	public List<Users> myRestCounties()
	{
		return usersService.listInAlphabeticalOrder();
	}
	
	@GetMapping("users/{name}")
	public Users findByUsersName(@PathVariable(name="name") String name)
	{
		return usersService.findByName(name);
	}
	
	@GetMapping("job")
	public List<Job> myRestJobs()
	{
		return jobService.listInAlphabeticalOrder();
	}
	
	@GetMapping("job/{name}")
	public Job findByJobName(@PathVariable(name="jobName") String jobName)
	{
		return jobService.findByJobName(jobName);
	}
	
	// Recall: POST is used to create a database record, PUT is used for updating a record
//	@PostMapping("/user")
//	public ResponseEntity<Users> addNewCounty(@RequestBody String countyName)
//	{
	//	Users newUsers = usersService.save(new Users(name);
		// Either a newCounty was created or is null.
		// If null, the county is already there so I return FOUND as my flag. 
		// If not null, the county has been created and I return that county with CREATED. 
		// There are better ways to do this - creating a dedicated class for each RunTimeException - but
		// it goes beyond the remit of this module. 
		// See http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services
	//	if ( newUsers == null )
	//		return new ResponseEntity<>(newCounty, HttpStatus.CONFLICT);
	//	return new ResponseEntity<>(newCounty, HttpStatus.CREATED);
//	}
}
