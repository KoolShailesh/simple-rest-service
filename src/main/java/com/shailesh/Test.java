package com.shailesh;

import java.util.ArrayList;
import java.util.List;

public class Test implements Runnable {
	
	
	public static void main(String[] args) {
		
		new Test().run();
	
		List< String> l = new ArrayList<>();
		
		
		l.stream().forEach(name --> System.out.print(name));
		

		
		
	}

	@Override
	public void run() {
	
		
		
		
	}

}
