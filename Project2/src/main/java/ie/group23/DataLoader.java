package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.group23.dao.BidDAO;
import ie.group23.dao.RoleDAO;
import ie.group23.domain.Bid;
import ie.group23.domain.Job;
import ie.group23.domain.Role;
import ie.group23.domain.Users;
import ie.group23.services.BidService;
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
	BidService bidService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Role role1 = new Role("mary@hotmail.com","ROLE_USER");
		Role rol4 = new Role("snsdv", null);
		roleDao.save(role1);
		Role role2 = new Role("john@yahoo.com","ROLE_USER");
		roleDao.save(role2);
		Role role3 = new Role("tom@eircom.net","ROLE_USER");
		roleDao.save(role3);

		Users Mary = new Users("Mary", "mary@hotmail.com", passwordEncoder.encode("password"), "0823409283", "ROLE_USER", true);
		Users John = new Users("John", "john@yahoo.com", passwordEncoder.encode("password"), "0862546790", "ROLE_USER", true);
		Users Tom = new Users("Tom", "tom@eircom.net", passwordEncoder.encode("password"), "0875418053", "ROLE_USER", true);
		
//		Users Mary = new Users("Mary", "mary@hotmail.com", passwordEncoder.encode("password"), "0823409283");
//		Users John = new Users("John", "john@yahoo.com", passwordEncoder.encode("password"), "0862546790");
//		Users Tom = new Users("Tom", "tom@eircom.net", passwordEncoder.encode("password"), "0875418053");

		Mary = usersService.save(Mary);
		log.info("LOMBOK TESTING: " + Mary);
		John = usersService.save(John);
		log.info("LOMBOK TESTING: " + John);
		Tom = usersService.save(Tom);
		log.info("LOMBOK TESTING: " + Tom);
		
		Job job1 = new Job("Bathroom Pluming", "Clogged pipes in the bathroom", "2019-11-15", Mary);
		Job job2 = new Job("Fittings", "Wardrobe to be fitted into the bedroom", "2019-12-05", John);
		Job job3 = new Job("Grinds", "Need some help with maths equations", "2019-12-01", Tom);
		Job job4 = new Job("House work", "New shed to be built", "2015-10-17", Mary);
		Job job5 = new Job("Phone problem", "Broken vscreen", "2013-09-01", Mary);
		Job job6 = new Job("Broadband", "Like a new broadband package", "2012-12-06", Mary);

		job1 = jobService.save(job1);
		log.info("LOMBOK TESTING: " + job1);
		job2 = jobService.save(job2);
		log.info("LOMBOK TESTING: " + job2);
		job3 = jobService.save(job3);
		log.info("LOMBOK TESTING: " + job3);
		job4 = jobService.save(job4);
		log.info("LOMBOK TESTING: " + job4);
		job5 = jobService.save(job5);
		log.info("LOMBOK TESTING: " + job5);
		job6 = jobService.save(job6);
		log.info("LOMBOK TESTING: " + job6);
		
		Bid bid1 = new Bid(12.00, Mary, job1);
		Bid bid2 = new Bid(20.00, John, job2);
		Bid bid3 = new Bid(14.50, Tom, job3);
		
		bid1 = bidService.save(bid1);
		log.info("BID TESTING: " + bid1);
		bid2 = bidService.save(bid2);
		log.info("BID TESTING: " + bid2);
		bid3 = bidService.save(bid3);
		log.info("BID TESTING: " + bid3);
		
	}

}
