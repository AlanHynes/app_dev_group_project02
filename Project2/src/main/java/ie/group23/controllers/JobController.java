package ie.group23.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.group23.domain.Job;
import ie.group23.formobjects.JobForm;
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
	
	@GetMapping("/newjob")
	public String addNewJobForm(Model model)
	{
		// Add the object county of type CountyForm to the model. 
		// This object will be populated with data from the form.
		model.addAttribute("jobForm", new JobForm());
		return "jobNew";
	}
	
	@PostMapping("/newjob")
	public String addNewJobSave(@Valid JobForm jobForm, BindingResult binding, RedirectAttributes redirectAttributes)
	{
		if (binding.hasErrors())
			return "jobNew";
		// countyForm has the new county's name so let's use it to create a County entity object.
		Job job = new Job(jobForm.getJobID(), jobForm.getJobname(), jobForm.getJobDesc(), jobForm.getLocalDate(), jobForm.getUser());
		job = jobservice.save(job);
		
		if (job !=null )
			return "redirect:showjob/"+job.getJobID();
		else {
			// starts again with empty form (new object)
			redirectAttributes.addFlashAttribute("duplicate", true);
			return "redirect:newjob";
		}
	}
}