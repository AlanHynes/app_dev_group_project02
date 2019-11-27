package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.group23.domain.Users;
import ie.group23.services.UsersService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	UsersService usersService;
	
//	@Autowired
//	TownService townService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		//Users John = new Users("John");
		Users Mary = new Users("Mary", "ehtieh", "mary@hotmail", "0823409283", 1);
		//Users Tom = new Users("Tom");
//		
		//UsersService.save(John);
		UsersService.save(Mary);
		//UsersService.save(Tom);
		
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