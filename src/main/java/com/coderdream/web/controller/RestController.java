package com.coderdream.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class RestController {

	/** 日志实例 */
//	private static final Logger logger = LoggerFactory
//			.getLogger(RestController.class);

	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String hello() {
		return "你好！hello";
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
//		logger.debug("msg {}", msg);
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}

	// @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	// public @ResponseBody
	// Person getPerson(@PathVariable("id") int id) {
	// logger.info("获取人员信息id=" + id);
	// Person person = new Person();
	// person.setName("张三");
	// person.setSex("男");
	// person.setAge(30);
	// person.setId(id);
	// return person;
	// }

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Integer id) {
		System.out.println("get" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public String post(@PathVariable("id") Integer id) {
		System.out.println("post" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public String put(@PathVariable("id") Integer id) {
		System.out.println("put" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		System.out.println("delete" + id);
		return "/hello";
	}

}