package ie.group23.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.group23.domain.Job;
import ie.group23.domain.Role;
import ie.group23.domain.Users;
import ie.group23.formobjects.JobForm;
import ie.group23.formobjects.UserForm;
import ie.group23.services.UsersService;

@Controller
public class UsersController{
	
	@Autowired
	UsersService usersservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/showuser/{userID}")
	public String showAUser(@PathVariable(name="userID") int userID, Model model) {
		Users user = usersservice.findUsers(userID);
		if (user == null) {
			model.addAttribute("userID", userID);
			return "not found error";
		}
		model.addAttribute("user", user);
		return "Users";
	}
	@GetMapping("/newuser")
	public String addNewUserForm(Model model)
	{
		// Add the object county of type CountyForm to the model. 
		// This object will be populated with data from the form.
		model.addAttribute("userForm", new UserForm());
		return "userNew";
	}
	
	@PostMapping("/newuser")
	public String addNewUserSave(@Valid UserForm userForm, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
			return "userNew";
		// countyForm has the new county's name so let's use it to create a County entity object.
		Users user = new Users(userForm.getUserID(), userForm.getName(), userForm.getEmail(), passwordEncoder.encode(userForm.getPassword()), userForm.getPhoneNum(), "ROLE_USER", true);
		user = usersservice.save(user);
		
		if (user !=null )
			return "redirect:showuser/"+user.getUserID();
		else {
			// starts again with empty form (new object)
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:newuser";
		}
	}
}
