package com.shailesh.rest;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.Greeting;
import com.shailesh.pojo.MyResponse;

@RestController
public class MyController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/hello")
	public MyResponse sayHello() {

		return MyResponse.builder().myMessage("Helllo").currentdDate(Instant.now()).build();
	}

	

	@PostMapping(value = "/printinput")
	public void printInput(@RequestBody MyResponse myResponseVO) {

		System.out.println(myResponseVO);

	}
}
