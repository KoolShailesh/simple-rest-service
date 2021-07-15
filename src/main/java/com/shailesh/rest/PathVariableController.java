package com.shailesh.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathv")
public class PathVariableController {
	
	
	@GetMapping("/test/{myVar}")
	public String pathVariableTest(@PathVariable("myVar") String var ) {
		System.out.println("" + var);
		return "Hello " + var;
		
	}

}
