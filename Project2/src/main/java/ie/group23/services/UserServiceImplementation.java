package ie.group23.services;

import org.springframework.beans.factory.annotation.Autowired;

import ie.group23.domain.Users;
import ie.project23.dao.UserDAO;

public class UserServiceImplementation implements UsersService{
	
	@Autowired 
	UserDAO userDao;
	
	@Override
	public Users findUsers(int userID) {
		if (userDao.existsById(userID))
			return userDao.findById(userID).get();
		return null;
	}

}
