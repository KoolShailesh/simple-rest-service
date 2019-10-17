package com.shailesh.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.LocalDateResponse;

@RestController
@RequestMapping("/localdatetime/")
public class LocalDateTimeTypeController {

	@GetMapping("/localdateresponse")
	public @ResponseBody LocalDateResponse getLocalDateResponse() {
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);
		LocalDateResponse build = LocalDateResponse.builder().myMessage("Hello").localDate(LocalDate.now()).localDateTime(now).build();
		System.out.println(build);
		return build;
	}

	@PostMapping(value = "/printilocaldateInput")
	public LocalDateResponse printLocalDateinput(@RequestBody LocalDateResponse myResponseVO) {

		myResponseVO.setMyMessage("Hello with new Message");
		System.out.println(myResponseVO);
		return myResponseVO;

	}

}
