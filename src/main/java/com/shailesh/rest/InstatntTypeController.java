package com.shailesh.rest;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shailesh.pojo.InstantResponse;

@RestController
@RequestMapping("/instant/")
public class InstatntTypeController {

	@GetMapping("/instantresponse")
	public @ResponseBody InstantResponse instantresponse() {
		Instant now = Instant.parse("2019-10-10T17:26:03.056Z");

		System.out.println(now);
		InstantResponse build = InstantResponse.builder().myMessage("Hello").instant(now).build();
		System.out.println(build);
		return build;
	}

	@PostMapping(value = "/printinstantinput")
	public InstantResponse printinstantinput(@RequestBody InstantResponse myResponseVO) {

		myResponseVO.setMyMessage("Hello with new Message");
		System.out.println(myResponseVO);
		return myResponseVO;

	}

}
