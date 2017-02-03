package com.smart.basic.timer;

import java.util.Date;
import java.util.TimerTask;

public class SimpleTimerTask  extends TimerTask{
	private int count = 0;
	public void run() {		
		System.out.println("execute task.");
		Date exeTime = (new Date(scheduledExecutionTime()));
		System.out.println("本次任务安排执行时间点为："+exeTime);
        if(++count > 5){cancel();}    
	}
}
