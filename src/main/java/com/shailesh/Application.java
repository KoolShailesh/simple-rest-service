package com.shailesh;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.annotation.PostConstruct;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shailesh.domain.OpeningHours;
import com.shailesh.repository.OpeningHoursRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories
public class Application {

	@Autowired
	@Qualifier("passwordEncoder")
	PasswordEncoder encoder;

	@Autowired
	private OpeningHoursRepository hoursRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@PostConstruct
	public void printPassword() {
		
		OpeningHours openingHours= OpeningHours.builder().closingTime(LocalTime.now()).day(DayOfWeek.SUNDAY).build();
		
		//hoursRepository.save(openingHours);
		
		LocalTime shopClosingTimeOn = 
				hoursRepository.getShopClosingTimeOn(DayOfWeek.SUNDAY);
		
		System.out.println(">>> >>>>>>>>>" + shopClosingTimeOn);
		
		System.err.println(encoder.encode("sssssssssssssssss"));
	}

	@Bean(name = "encryptorBean")
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("password");
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config);
		return encryptor;
	}

	@Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder getPasswordEncoder() {
		
		
		

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2B);
		return bCryptPasswordEncoder;

	}
}
