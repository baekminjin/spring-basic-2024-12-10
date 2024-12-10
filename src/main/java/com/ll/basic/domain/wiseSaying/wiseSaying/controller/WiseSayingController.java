package com.ll.basic.domain.wiseSaying.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@ResponseBody와 @Controller 합친 것
//@ResponseBody //여기에 붙이면 모든 메소드에 적용된다.
@RequiredArgsConstructor //final 붙은 것을 자동으로 생성자 생서해주는 것
 public class WiseSayingController {
	private final WiseSayingService wiseSayingService;

	/*
	//@Autowired // Component new WiseSayingService <- 스프링 부트가 해준다. // 생략이 가능하다.
	public WiseSayingController(WiseSayingService wiseSayingService) {
		this.wiseSayingService = wiseSayingService;
	}
	*/


	@GetMapping("/wiseSayings") //목록

	public List<WiseSaying> getItems() {
		return wiseSayingService.findAll();
	}


	@GetMapping("/wiseSayings/write") //등록
	public WiseSaying write(
			String content,
			@RequestParam(defaultValue = "무명") String author
	)
	{
		return wiseSayingService.write(content, author);
	}

}