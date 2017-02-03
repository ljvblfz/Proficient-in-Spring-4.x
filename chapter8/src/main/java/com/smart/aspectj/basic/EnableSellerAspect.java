package com.smart.aspectj.basic;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import com.smart.Seller;
import com.smart.SmartSeller;


@Aspect
public class EnableSellerAspect {
   @DeclareParents(value="com.smart.NaiveWaiter",
		   defaultImpl=SmartSeller.class)
   public  Seller seller;
}
