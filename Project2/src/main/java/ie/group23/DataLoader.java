package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.group23.domain.Job;
import ie.group23.domain.Users;
import ie.group23.services.JobService;
import ie.group23.services.UsersService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

	@Autowired
	UsersService usersService;
	
	@Autowired
	JobService jobService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
<<<<<<< HEAD
		Users John = new Users("John", "john@yahoo.com", "bgvrje", "0873657901");
		Users Mary = new Users("Mary", "mary@hotmail.com", "ehtieh", "0823409283");
		Users Tom = new Users("Tom", "tom@eircom.net", "gfnklj", "0862954120");
//		
=======
		Users John = new Users("John", "john@yahoo.com", "bfjkds", "0862546790");
		Users Mary = new Users("Mary", "mary@hotmail.com", "ehtieh", "0823409283");
		Users Tom = new Users("Tom", "tom@eircom.net", "gnvrwk", "0875418053");
		
>>>>>>> User-Database-Populating
		John = usersService.save(John);
		log.info("LOMBOK TESTING: " + John);
		Mary = usersService.save(Mary);
		log.info("LOMBOK TESTING: " + Mary);
		Tom = usersService.save(Tom);
		log.info("LOMBOK TESTING: " + Tom);
<<<<<<< HEAD
		
		Job job1 = new Job("Bathroom Pluming", "Clogged pipes in the bathroom", "2019-11-15");
		Job job2 = new Job("Fittings", "Wardrobe to be fitted into the bedroom", "2019-12-05");
		Job job3 = new Job("Grinds", "Need some help with maths equations", "2019-12-01");
		
		job1 = jobService.save(job1);
		log.info("LOMBOK TESTING: " + job1);
		job2 = jobService.save(job2);
		log.info("LOMBOK TESTING: " + job2);
		job3 = jobService.save(job3);
		log.info("LOMBOK TESTING: " + job3);
=======
>>>>>>> User-Database-Populating
		
	}

}