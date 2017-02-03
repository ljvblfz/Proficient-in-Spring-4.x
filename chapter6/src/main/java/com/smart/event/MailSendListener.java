package com.smart.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{

	public void onApplicationEvent(MailSendEvent event) {
			MailSendEvent mse = (MailSendEvent) event;
			System.out.println("MailSendListener:向" + mse.getTo() + "发送完一封邮件");
	}
}
