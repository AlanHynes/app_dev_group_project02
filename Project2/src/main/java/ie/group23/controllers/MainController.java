package ie.group23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

//	@PostMapping(value= {"/","**"})
//	public String handlePostIndexRequest() {
//		return "index";
//	}
	
	@GetMapping(value= {"/", "/index"})
	public String handleIndexRequest()
	{
		return "index";
	}
//	@GetMapping(value="/login")
//	public String login()
//	{
//		return "login";
//	}
	
}
