package com.shailesh.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.EnumRequest;

@RestController
@RequestMapping(value = "/enums")
public class EnumRequestController {
	
	@PostMapping("tv")
	public void processEnumRequest(@Valid @RequestBody EnumRequest enumRequest) {
		
		System.out.println(enumRequest);
		
	}

}
