package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody //여기에 붙이면 모든 메소드에 적용된다.
 public class WiseSayingController {
	private final WiseSayingService wiseSayingService;

	@Autowired //new WiseSayingService <- 스프링 부트가 해준다. // 받으면 된다.
	public WiseSayingController(WiseSayingService wiseSayingService) {
		this.wiseSayingService = wiseSayingService;
	}

	@GetMapping("/wiseSayings")

	public List<WiseSaying> getItems() {
		return wiseSayingService.findAll();
	}
}