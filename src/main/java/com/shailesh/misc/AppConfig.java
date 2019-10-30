package com.shailesh.misc;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class AppConfig {
	
	
	@Resource(name="props")
	private Map<String, String> maps;

	
	@PostConstruct
	void print() {
		System.out.println(maps);
	}
	
	
	


}
