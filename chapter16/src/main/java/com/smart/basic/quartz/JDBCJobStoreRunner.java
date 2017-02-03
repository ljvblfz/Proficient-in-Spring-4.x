package com.smart.basic.quartz;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
public class JDBCJobStoreRunner {
	public static void main(String args[]) {
		try {
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			String[] triggerGroups = scheduler.getTriggerGroupNames();
			for (int i = 0; i < triggerGroups.length; i++) {
				String[] triggers = scheduler.getTriggerNames(triggerGroups[i]);
				for (int j = 0; j < triggers.length; j++) {
					Trigger tg = scheduler.getTrigger(triggers[j],
							triggerGroups[i]);
					if (tg instanceof SimpleTrigger
							&& tg.getFullName().equals("tgroup1.trigger1_1")) {
//						((SimpleTrigger) tg).setRepeatCount(100);
						scheduler.rescheduleJob(triggers[j], triggerGroups[i],tg);
					}
				}
			}
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
