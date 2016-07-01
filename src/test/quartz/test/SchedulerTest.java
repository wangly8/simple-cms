package test.quartz.test;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchedulerTest {

	void run() throws SchedulerException{
		Logger log = LoggerFactory.getLogger(SchedulerTest.class);
		Scheduler sf = new StdSchedulerFactory().getScheduler();
		
		JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1").build();
		Date runTime = evenMinuteDate(new Date());
		Trigger trigger = newTrigger()
	            .withIdentity("trigger1", "group1")
	            .startAt(runTime)
	            .build();
		sf.scheduleJob(job, trigger);
		sf.start();
		try {
            Thread.sleep(65L * 1000L); 
        } catch (Exception e) {
        }

        // shut down the scheduler
        log.info("------- Shutting Down ---------------------");
        sf.shutdown(true);
        log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws SchedulerException {
		PropertyConfigurator.configure("src/config/log4j.properties");
		new SchedulerTest().run();
	}
}
