package com.coderdream.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层代码
 * 
 * @author 591791
 * @date 2014年11月27日
 */
@Controller
public class MyController {

	@RequestMapping("login") // 用来处理前台的login请求
	private @ResponseBody String hello(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		return "Hello " + username + ",Your password is: " + password;
	}

}
