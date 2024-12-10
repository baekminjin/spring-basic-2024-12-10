package com.ll.basic.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@GetMapping("/")
	@ResponseBody //응답값이 고객에게 보여진다.
	public String showmain(){
		return "안녕하세요";
	}
}
