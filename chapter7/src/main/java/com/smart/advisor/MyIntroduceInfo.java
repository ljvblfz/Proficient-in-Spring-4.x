package com.smart.advisor;

import org.springframework.aop.support.IntroductionInfoSupport;

import com.smart.introduce.Monitorable;

public class MyIntroduceInfo extends IntroductionInfoSupport{
   public MyIntroduceInfo(){
	   super();
	   super.publishedInterfaces.add(Monitorable.class);
   }
}
