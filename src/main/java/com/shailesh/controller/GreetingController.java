package com.shailesh.controller;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.vo.Greeting;

@RestController
@CrossOrigin(origins = "http://localhost:8181")
public class GreetingController {

	
	@Autowired
	@Qualifier("encryptorBean")
	private StringEncryptor encryptor;
	
	@Value("${spring.myapp.mybigdecimal}")
	private BigDecimal bigdecimal; 
	
	@Value("${spring.myapp.messagewithURL}")
	private String message;
	
	
	
	@Autowired
	private PasswordEncoder encoder;
	
    private static final String template = "Hello, %s ! and encrpted is %s and encoded string is %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting1")
    public Greeting greeting(@RequestParam(value="name", defaultValue="LKjuy67$%deklj") String name) {
        String encode = encryptor.encrypt("LKjuy67$%deklj");
        System.out.println(encode);
		Greeting greeting = new Greeting(counter.incrementAndGet(),
                            String.format(template, name,encryptor.encrypt(name),encode) +message );
        
        System.out.println(bigdecimal);
        
        System.out.println("Message is "  + message);
		return greeting;
    }
 
    
}
