package ie.group23.services;

import java.util.List;

import ie.group23.domain.Bid;

public interface BidService {
	List<Bid> listInAlphabeticalOrder();
	Bid findBid(int bidID);
	Bid save(Bid bid);
	Bid updateBid(int jobID, double bidAmount); 
}
