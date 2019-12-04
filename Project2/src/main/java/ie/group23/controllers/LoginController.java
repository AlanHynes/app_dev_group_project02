package ie.group23.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
	
	@GetMapping(value="/login")
	public String login()
	{
		return "login";
	}

}
