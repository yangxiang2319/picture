package com.yangx.picture.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.yangx.picture.domain.user.UserInfo;
import com.yangx.picture.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/regist")
public class RegistController {
	
	@Autowired
	private UserService userService;

	/**
	 * 判断用户名是否已存在
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/usernames",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String helloTest(HttpServletRequest req){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			//用户名
			String  username = req.getParameter("registUserName");
			log.info("注册用户名：{}",username);
			if(userService.hasUsername(username)){
				log.info("{}用户名重复",username);
				map.put("code", "1");//用户名重复
			}else{
				log.info("用户名不重复",username);
				map.put("code", "0");//用户名不重复，可用
			}
		} catch (Exception e) {
			log.error("判断用户名是否已存在时，系统发生异常：",e);
			map.put("code", "3");//系统发生异常
		}
		
		return JSON.toJSONString(map);
	}
	
	/**
	 * 注册用户
	 */
	@Transactional
	@RequestMapping(value="/enroll",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public String registUser(HttpServletRequest req){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			//用户名
			String  username = req.getParameter("registUserName");
			log.info("注册用户名：{}",username);
			//密码
			String  password = req.getParameter("registPassWord");
			log.info("注册密码：{}",password);
			
			UserInfo user = new UserInfo();
			user.setUsername(username);
			user.setPassword(password);
			//注册
			userService.registUser(user);
			map.put("code", "0");//正常
		} catch (Exception e) {
			log.error("注册用户时，系统发生异常：",e);
			map.put("code", "3");//系统发生异常
		}
		
		return JSON.toJSONString(map);
	}
}
