package ie.group23.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ie.group23.domain.Users;

@Repository
public interface UserDAO extends JpaRepository<Users, Integer>{
	//Users findByUsersName(String name);
}