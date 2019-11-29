package ie.group23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.group23.dao.UserDAO;
import ie.group23.domain.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImplementation implements UsersService{
	
	@Autowired 
	UserDAO userDao;
	
	@Override
	public Users findUsers(int userID) {
		if (userDao.existsById(userID))
			return userDao.findById(userID).get();
		return null;
	}

	@Override
	public Users findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users save(Users user) {
		return userDao.save(user);
	}

	@Override
	public List<Users> listInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
