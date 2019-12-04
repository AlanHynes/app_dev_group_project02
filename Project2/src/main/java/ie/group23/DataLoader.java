package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.group23.domain.Users;
import ie.group23.services.UsersService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

	@Autowired
	UsersService usersService;
	
//	@Autowired
//	TownService townService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Users John = new Users("John", "john@yahoo.com", "bfjkds", "0862546790");
		Users Mary = new Users("Mary", "mary@hotmail.com", "ehtieh", "0823409283");
		Users Tom = new Users("Tom", "tom@eircom.net", "gnvrwk", "0875418053");
		
		John = usersService.save(John);
		log.info("LOMBOK TESTING: " + John);
		Mary = usersService.save(Mary);
		log.info("LOMBOK TESTING: " + Mary);
		Tom = usersService.save(Tom);
		log.info("LOMBOK TESTING: " + Tom);
		
//		townService.save(new Town("Blackrock", cork));
//		townService.save(new Town("Wilton", cork));
//		townService.save(new Town("Bishopstown", cork));
//		townService.save(new Town("Mayfield", cork));
//		
//		townService.save(new Town("Blackrock", dublin));
//		townService.save(new Town("Malahide", dublin));
//		townService.save(new Town("Dundrum", dublin));
//		townService.save(new Town("Tallaght", dublin));
//		
//		townService.save(new Town("Tralee", kerry));
//		townService.save(new Town("Ballyferriter", kerry));
//		townService.save(new Town("Killarney", kerry));
//		townService.save(new Town("Dingle", kerry));
	}

}