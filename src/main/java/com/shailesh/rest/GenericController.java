package com.shailesh.rest;

import java.sql.Connection;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.Greeting;

@RestController
public class GenericController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Value("#{ ${spring.myapp.usenewval}  ? '${spring.myapp.newval}' : '${spring.myapp.oldval}}'}")
	private String message;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/checkconnection")
	public String checkCnonnection() {
		StringBuffer result = new StringBuffer();
		try {
			result.append(new Date());
			
			result.append("\n1. ");
			System.out.println("1-> " + jdbcTemplate);
			result.append("jdbcTemplate");
			
			result.append("\n2. ");
			System.out.println("2-> " + jdbcTemplate.getDataSource());
			result.append(jdbcTemplate.getDataSource());
			
			result.append("\n3. ");
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			System.out.println("3-> " + connection);
			result.append( connection);
			
			System.out.println("4-> " + dataSource);
			result.append("dataSource");
			result.append("\n");

		} catch (Exception e) {
			e.printStackTrace();
			result.append("Error:").append(e.getMessage());
		}
		return result.toString();
	}

}
