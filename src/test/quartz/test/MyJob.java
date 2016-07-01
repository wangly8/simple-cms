package test.quartz.test;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("测试Quartz"+new Date()); 
	}

}
