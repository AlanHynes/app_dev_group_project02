package ie.group23.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ie.group23.domain.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{

}
