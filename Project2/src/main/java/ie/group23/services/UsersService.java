package ie.group23.services;

import java.util.List;

import ie.group23.domain.Users;

public interface UsersService {

	Users findUsers(int userID);
	//boolean deleteCounty(County county);
	//boolean deleteCounty(int id);
	Users findByName(String name);
	//List<County> listInAlphabeticalOrder(); 
	//String findCountyName(int id);
	//List<County> findCountiesWithTownName(String townName);
	static Users save(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
