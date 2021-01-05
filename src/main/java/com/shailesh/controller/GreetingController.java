package com.shailesh.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.domain.Template;
import com.shailesh.repository.MyTemplateRepository;
import com.shailesh.vo.Greeting;

@RestController
public class GreetingController {

	
	@Autowired
	@Qualifier("encryptorBean")
	private StringEncryptor encryptor;
	
	
	@Autowired
	MyTemplateRepository templateRepo;
	
	
	@Autowired
	private PasswordEncoder encoder;
	
    private static final String template = "Hello, %s ! and encrpted is %s and encoded string is %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="LKjuy67$%deklj") String name) {
        String encode = encryptor.encrypt("LKjuy67$%deklj");
        System.out.println(encode);
		Greeting greeting = new Greeting(counter.incrementAndGet(),
                            String.format(template, name,encryptor.encrypt(name),encode));
        
//        System.out.println(encoder.);
		return greeting;
    }
    @RequestMapping("/template")
    public List<Template> getTempldate() {
    	
    	char activeFlag ='Y';
		String templateName = "hello";
		return templateRepo.findByNettingTemplateId("1");
    }
    
}
