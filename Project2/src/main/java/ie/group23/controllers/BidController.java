package ie.group23.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.group23.domain.Bid;
import ie.group23.domain.Job;
import ie.group23.formobjects.BidForm;
import ie.group23.formobjects.JobForm;
import ie.group23.services.BidService;

@Controller
public class BidController {
	
	@Autowired
	BidService bidService;
	
	@GetMapping("/showbids/{bidID}")
	public String showBids(Model model)
	{
		List<Bid> bids = bidService.listInAlphabeticalOrder();
		model.addAttribute("bids", bids);
		System.out.println(model);
		return "Bids";
	}
	
	@GetMapping("/showbid/{bidID}")
	public String showABid(@PathVariable(name="bidID") int bidID, Model model) {
		Bid bid = bidService.findBid(bidID);
		if (bid == null) {
			model.addAttribute("bidID", bidID);
			return "not found error";
		}
		model.addAttribute("bid", bid);
		return "bid";
	}
	
	@PostMapping("/bid")
	public String addNewBid(@ModelAttribute("bid") @Valid BidForm bidForm, BindingResult binding, @RequestParam(name="jobID") int jobID, RedirectAttributes redirectAttributes )
	{
		if (binding.hasErrors())
			return "showjobs";
		// countyForm has the new county's name so let's use it to create a County entity object.
		Bid bid = bidService.updateBid(jobID,bidForm.getBidAmount());
		
		if (bid !=null )
			return "redirect:newbid/"+bid.getBidID();
		else {
			// starts again with empty form (new object)
			redirectAttributes.addFlashAttribute("incorrect", true);
			return "redirect:showjobs";
		}
	}

}
