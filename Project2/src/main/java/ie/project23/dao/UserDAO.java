package ie.project23.dao;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserDAO {
	String showAUser(@PathVariable(name="userID") int userID, Model model);
}
