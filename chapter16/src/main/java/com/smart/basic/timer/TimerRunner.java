package com.smart.basic.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerRunner {
	public static void main(String[] args) {
         Timer timer = new Timer();
         TimerTask task = new SimpleTimerTask();
         timer.schedule(task,1000L,1000L);     
	}
}
