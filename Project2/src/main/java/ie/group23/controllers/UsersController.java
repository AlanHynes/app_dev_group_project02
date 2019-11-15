package ie.group23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import ie.group23.entities.UsersEntities;
import ie.group23.services.UsersService;
import ie.project23.dao.UserDAO;

//public class UsersController implements UserDAO{
//	@GetMapping("/user/{userID}")
//	public String showAUser(@PathVariable(name="userID") int userID, Model model) {
//		Users user = UsersService.findUsers(userID);
//		if (user == null) {
//			model.addAttribute("userID", userID);
//			return "not found error";
//		}
//		model.addAttribute("user", user);
//		return "user";
//	}
//}
