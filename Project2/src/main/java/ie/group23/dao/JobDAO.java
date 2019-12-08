package ie.group23.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.group23.domain.Job;

@Repository
public interface JobDAO extends JpaRepository<Job, Integer>{

	List<Job> findAllByOrderByJobnameAsc();

}
