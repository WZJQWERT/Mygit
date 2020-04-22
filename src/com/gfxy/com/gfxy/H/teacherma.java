package com.gfxy.com.gfxy.H;

public class teacherma implements TakeAway {
	private TakeAway takeaway;
   
	
	public teacherma(TakeAway takeaway){
		this.takeaway = takeaway;
	}
	
	@Override
	public void People() {
		System.out.println("做饭");
		
		takeaway.People();
		System.out.println("打扫");
	}
 
}
