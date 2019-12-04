package ie.group23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ie.group23.dao.RoleDAO;
import ie.group23.domain.Role;
import ie.group23.domain.Users;
import ie.group23.services.UsersService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

	@Autowired
	UsersService usersService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RoleDAO roleDAO;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role role1 = new Role("mary@hotmail","ROLE_USER");
		roleDAO.save(role1);
		
		//Users John = new Users("John");
		Users Mary = new Users("Mary","mary@hotmail",passwordEncoder.encode("password"), "0823409283",role1,true);
		//Users Tom = new Users("Tom");
//		
		//UsersService.save(John);
		Mary = usersService.save(Mary);
		log.info("LOMBOK TESTING: " + Mary);
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