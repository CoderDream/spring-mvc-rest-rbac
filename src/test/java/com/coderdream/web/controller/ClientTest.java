package com.coderdream.web.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import junit.framework.Assert;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-2-26
 * <p>
 * Version: 1.0
 */
public class ClientTest {
	private RestTemplate restTemplate = new RestTemplate();

	// @BeforeClass
	// public static void beforeClass() throws Exception {
	// // 创建一个server
	// // server = new Server(8080);
	// // WebAppContext context = new WebAppContext();
	// // String webapp = "shiro-example-chapter20/src/main/webapp";
	// // context.setDescriptor(webapp + "/WEB-INF/web.xml"); // 指定web.xml配置文件
	// // context.setResourceBase(webapp); // 指定webapp目录
	// // context.setContextPath("/");
	// // context.setParentLoaderPriority(true);
	// //
	// // server.setHandler(context);
	// // server.start();
	// }
	//
	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess() {
		String username = "zhang";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/rest/getPermission")
				.queryParams(params).build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		Assert.assertEquals("hello", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_00() {
		String username = "admin";
		String url = UriComponentsBuilder
				.fromHttpUrl(
						"http://localhost:8080/rest/getPermissions/" + username)
				.build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		// Assert.assertEquals("[\"user:create\",\"user:update\",\"menu:create\"]",
		// responseEntity.getBody());
		Assert.assertEquals(
				"[\"user:*\",\"role:*\",\"resource:*\",\"session:*\",\"organization:*\"]",
				responseEntity.getBody());

	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_01() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/rest/getPermission").build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		Assert.assertEquals("permissions", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_02() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/rest/hello").build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		Assert.assertEquals("你好！hello", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_03() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl("http://localhost:8080/rest/say/" + username)
				.build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		Assert.assertEquals("{\"msg\":\"you say:'admin'\"}",
				responseEntity.getBody());
	}

}
