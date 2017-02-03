package com.smart;

import com.smart.anno.NeedTest;

public interface Waiter {
	@NeedTest
	public void greetTo(String clientName);	
	public void serveTo(String clientName);
}
