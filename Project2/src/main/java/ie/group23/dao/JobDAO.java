package ie.group23.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.group23.domain.Job;

public interface JobDAO extends JpaRepository<Job, Integer>{

}
