package ie.project23.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import ie.group23.domain.Users;

public interface UserDAO extends JpaRepository<Users, Integer>{
//	String showAUser(@PathVariable(name="userID") int userID, Model model);
	
}