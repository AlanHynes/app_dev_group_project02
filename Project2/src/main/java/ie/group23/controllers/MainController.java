package ie.group23.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@GetMapping(value="/")
	public String handleIndexRequest(Model model) {
		model.addAttribute("name", "fred");
		return "index";
		
	}
	
	@PostMapping(value= {"/","**"})
	public String handlePostIndexRequest() {
		return "index";
	}
}
