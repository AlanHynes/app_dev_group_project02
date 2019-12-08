package ie.group23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ie.group23.domain.Bid;
import ie.group23.domain.Job;
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

}
