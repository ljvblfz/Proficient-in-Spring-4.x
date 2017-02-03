package com.smart.ioc;

public class MoAttack implements ActorArrangable {
	private GeLi geli;

	public void injectGeli(GeLi geli) {
		this.geli = geli;		
	}
	
	public void cityGateAsk() {
		geli.responseAsk("墨者革离");
	}
}