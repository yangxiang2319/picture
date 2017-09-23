package com.yangx.picture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/picture")
public class LoginController {

	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "index";
	}
	
}
