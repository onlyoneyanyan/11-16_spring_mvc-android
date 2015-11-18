package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//朋友一定很好奇这个是干什么的，这个呢就是告诉spring这个类是Controller 
@Controller
// 是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
@RequestMapping("HelloController")
public class HelloController {

	// value： 指定请求的实际地址；
	// method： 指定请求的method类型， GET、POST、PUT、DELETE等；
	@RequestMapping(value = "/hello.json", method = RequestMethod.GET)
	// 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
	@ResponseBody
	// 那么我们要访问此方法是 完整路径应该是http://ip地址:端口/SpringMVC/HelloController/hello.json
	public Object hello() {
		return "Hello SpringMVC!";
	}
}
