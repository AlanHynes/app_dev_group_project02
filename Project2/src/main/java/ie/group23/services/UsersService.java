package ie.group23.services;

import java.util.List;

import ie.group23.domain.Users;

public interface UsersService {

	Users findUsers(int userID);
	//boolean deleteCounty(County county);
	//boolean deleteCounty(int id);
	Users findByName(String name);
	List<Users> listInAlphabeticalOrder(); 
	//String findCountyName(int id);
	//List<County> findCountiesWithTownName(String townName);
	Users save(Users user) ;
	
}
