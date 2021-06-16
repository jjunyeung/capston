package com.cos.attend.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.attend.config.auth.principalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index() { //컨트롤러에서 세션 접근
		return "index";
	}

}
