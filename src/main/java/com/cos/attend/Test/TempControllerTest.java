package com.cos.attend.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
//http://localhost:8000/attend/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일 리턴 기본 경로 : src/main/resources/static
		//리턴 명 : /home.html
		//풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("temp/jsp")
	public String tempJsp() {
		//prifix : /WEB-INF/views/
		//suffix : .jsp
		//풀네임: /WEB-INF/view/test.jsp
		return"test";
	}
}
