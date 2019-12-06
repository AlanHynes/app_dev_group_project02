package ie.group23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ie.group23.domain.Job;
import ie.group23.services.JobService;

@Controller
public class JobController {

	@Autowired
	JobService jobservice;
	
	@GetMapping("/showjobs") 
	public String showJobs(Model model)
	{
		List<Job> jobs = jobservice.listInAlphabeticalOrder();
		model.addAttribute("jobs", jobs);
		System.out.println(model);
		return "Jobs";
	}
	
	@GetMapping("/showjob/{jobID}")
	public String showAJob(@PathVariable(name="jobID") int jobID, Model model) {
		Job job = jobservice.findJob(jobID);
		if (job == null) {
			model.addAttribute("jobID", jobID);
			return "not found error";
		}
		model.addAttribute("job", job);
		return "job";
	}
}