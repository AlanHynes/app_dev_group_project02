package ie.group23.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.group23.domain.Bid;

public interface BidDAO extends JpaRepository<Bid, Integer>{

}
