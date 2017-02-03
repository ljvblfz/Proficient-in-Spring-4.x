package com.smart.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CalendarExample {

    public static void main(String[] args) throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        AnnualCalendar holidays = new AnnualCalendar();
        //五一劳动节
        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH,5);
        laborDay.add(Calendar.DATE,1);
        holidays.setDayExcluded(laborDay, true);       
        //国庆节
        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH,10);
        nationalDay.add(Calendar.DATE,1);
        holidays.setDayExcluded(nationalDay, true);


        scheduler.addCalendar("holidays", holidays, false, false);
        
        //从5月1号10am开始
        Date runDate = TriggerUtils.getDateOf(0,0, 10, 1, 5);
        JobDetail job = new JobDetail("job1", "group1", SimpleJob.class);
        SimpleTrigger trigger = new SimpleTrigger("trigger1", "group1", 
                runDate, 
                null, 
                SimpleTrigger.REPEAT_INDEFINITELY, 
                60L * 60L * 1000L);
        //让Trigger遵守节日的规则（排除节日）
        trigger.setCalendarName("holidays");
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        try {
            // wait 30 seconds to show jobs
            Thread.sleep(30L * 1000L); 
            // executing...
        } catch (Exception e) {
        }            
        scheduler.shutdown(true);
    }
}