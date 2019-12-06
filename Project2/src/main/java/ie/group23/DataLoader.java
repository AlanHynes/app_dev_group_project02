package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.group23.dao.RoleDAO;
import ie.group23.domain.Job;
import ie.group23.domain.Role;
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
	
	@Autowired
	RoleDAO roleDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Role role1 = new Role("mary@hotmail.com","ROLE_USER");
		roleDao.save(role1);
		Role role2 = new Role("john@yahoo.com","ROLE_USER");
		roleDao.save(role2);
		Role role3 = new Role("tom@eircom.net","ROLE_USER");
		roleDao.save(role3);

		Users Mary = new Users("Mary", "mary@hotmail.com", passwordEncoder.encode("password"), "0823409283", role1, true);
		Users John = new Users("John", "john@yahoo.com", passwordEncoder.encode("password"), "0862546790", role2, true);
		Users Tom = new Users("Tom", "tom@eircom.net", passwordEncoder.encode("password"), "0875418053", role3, true);

		Mary = usersService.save(Mary);
		log.info("LOMBOK TESTING: " + Mary);
		John = usersService.save(John);
		log.info("LOMBOK TESTING: " + John);
		Tom = usersService.save(Tom);
		log.info("LOMBOK TESTING: " + Tom);

		Job job1 = new Job("Bathroom Pluming", "Clogged pipes in the bathroom", "2019-11-15");
		Job job2 = new Job("Fittings", "Wardrobe to be fitted into the bedroom", "2019-12-05");
		Job job3 = new Job("Grinds", "Need some help with maths equations", "2019-12-01");

		job1 = jobService.save(job1);
		log.info("LOMBOK TESTING: " + job1);
		job2 = jobService.save(job2);
		log.info("LOMBOK TESTING: " + job2);
		job3 = jobService.save(job3);
		log.info("LOMBOK TESTING: " + job3);

	}

}
