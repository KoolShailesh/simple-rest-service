package com.shailesh.rest;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.Greeting;
import com.shailesh.pojo.GreetingsVO;

@RestController
public class GenericController {

	@Value("#{ ${spring.myapp.usenewval}  ? '${spring.myapp.newval}' : '${spring.myapp.oldval}}'}")
	private String message;

	/// @Value("${secretz.db.url}")
	private String secretURL;

	// @Value("${secretz.db.user}")
	private String secretUser;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${management.metrics.export.elastic.index}")
	private String metricName;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "192.168.29.118")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("secretURL " + secretURL);
		System.out.println("secretUser " + secretUser);
		System.out.println("Applicaton Name: " + applicationName + " metricName: " + metricName);
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping(value = "/postgreeting", produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting greetingPost(@RequestBody @Valid GreetingsVO greetingsVO) {

		
		return new Greeting(counter.incrementAndGet(), String.format(template, greetingsVO));
	}

}
