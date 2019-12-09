package ie.group23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.group23.dao.BidDAO;
import ie.group23.domain.Bid;
import ie.group23.domain.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BidServiceImplementation implements BidService{

	@Autowired
	BidDAO bidDao;
	
	@Autowired
	UsersService usersservice;
	
	@Override
	public Bid findBid(int bidID) {
		if (bidDao.existsById(bidID))
			return bidDao.findById(bidID).get();
		return null;
	}
	@Override
	public List<Bid> listInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Bid save(Bid bid) {
		return bidDao.save(bid);
	}
	@Override
	public Bid updateBid(int jobID, double bidAmount) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
