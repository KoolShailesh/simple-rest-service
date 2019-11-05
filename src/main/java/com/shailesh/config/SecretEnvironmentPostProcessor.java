package com.shailesh.config;

import static org.springframework.core.env.StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

@Order(Ordered.LOWEST_PRECEDENCE)
public class SecretEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

		Properties prop = new Properties();

		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("secretsz")) {
			//try (InputStream input = new FileInputStream("path/to/secretsz")) {

			if (input == null) {
				System.out.println("Sorry, unable to find secretsz");
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Map<String, Object> prefixed = new LinkedHashMap<>((Map) prop);

		environment.getPropertySources().addAfter(SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
				new MapPropertySource("prefixer", prefixed));
	}

}