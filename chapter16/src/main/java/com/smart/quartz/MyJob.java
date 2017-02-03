package com.smart.quartz;

import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.context.ApplicationContext;

public class MyJob implements StatefulJob {
	public void execute(JobExecutionContext jctx) throws JobExecutionException {
//		Map dataMap = jctx.getJobDetail().getJobDataMap();
		Map dataMap = jctx.getTrigger().getJobDataMap();
		String size =(String)dataMap.get("size");
        ApplicationContext ctx = (ApplicationContext)dataMap.get("applicationContext");
        System.out.println("size:"+size);
        dataMap.put("size",size+"0");
        
        String count =(String)dataMap.get("count");
        System.out.println("count:"+count);
	}
}
