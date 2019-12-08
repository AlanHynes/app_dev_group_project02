package ie.group23;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ie.group23.domain.Job;
import ie.group23.services.JobService;
import lombok.extern.slf4j.Slf4j;

import static java.time.temporal.ChronoUnit.DAYS;

@Component   // this class becomes a Spring-managed bean
@Slf4j       // part of Lombok, this creates a logger called log 
public class Scheduler {

 // cron = "seconds hours minutes day month year"
 // At 13:02:00 every day of every month of every year....
 @Scheduled(cron = "0 02 13 * * *")
 public void timeForTea() {
        log.info("Hello it is time for tea");
 }

 // Scheduled events can also interact with the database.
 // Here I am using it to log the towns currently in the database
 // but you might use it to change the status of jobs which are
 // over 20 days old. 
 @Autowired
 JobService jobservice;

 // Every 60000ms print the list of towns.
 @Scheduled(fixedRate = 60000)
 public void listProjects() {
	 List<Job> jobs = jobservice.listInAlphabeticalOrder();
	 
//	 jobs.forEach(job -> {
//		 if(DAYS.between(job.getLocalDate(), LocalDate.now()) > 20) {
//			 jobservice.closeJob(job.getJobID());
//		 }
//	 });
	 
   String s = "";
   for (Job t: jobs)
      s += t.getJobname() + " ";
   log.info(s);
 }
}