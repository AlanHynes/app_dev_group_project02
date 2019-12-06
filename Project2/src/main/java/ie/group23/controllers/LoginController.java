package ie.group23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value="/login")
	public String login()
	{
		return "login";
	}
	
	
	@GetMapping(value="/403")
	public String preventAccess()
	{
		return "403";
	}
	
}
