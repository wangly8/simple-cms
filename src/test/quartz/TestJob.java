package test.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job{

	SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date d = new Date();  
    String returnstr = DateFormat.format(d);    
  
    public void execute(JobExecutionContext arg0) throws JobExecutionException {  
        // TODO Auto-generated method stub  
        System.out.println(returnstr+"★★★★★★★★★★★");  
    }  
}
