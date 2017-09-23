package com.yangx.picture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.yangx.picture.domain.user.UserInfo;
import com.yangx.picture.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	
	@Autowired
	private UserService userService;

	/**
	 * 测试
	 * @author yangx
	 * 2017-09-12 09:34:45
	 */
	@RequestMapping(value="/hello",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String helloTest(HttpServletRequest req){
		List<UserInfo> list = userService.getUserInfo();
		return JSON.toJSONString(list);
	}
}
