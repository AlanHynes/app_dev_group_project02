package ie.group23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ie.group23.domain.Users;
//import ie.group23.entities.UsersEntities;
import ie.group23.services.UsersService;

public class UsersController{
	
	@Autowired
	UsersService usersservice;
	
	@GetMapping("/user/{userID}")
	public String showAUser(@PathVariable(name="userID") int userID, Model model) {
		Users user = usersservice.findUsers(userID);
		if (user == null) {
			model.addAttribute("userID", userID);
			return "not found error";
		}
		model.addAttribute("user", user);
		return "user";
	}
}
