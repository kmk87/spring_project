package com.mk.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// 클라이언트가 요청한 서비스 주소와 메소드를 연결
	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
