package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.entity.UserEntity;

//这一步肯定少不了，前面有介绍就不再介绍了 
@Controller
// 定义访问登录接口的父路径，前面有介绍也不多介绍了
@RequestMapping("LoginController")
public class LoginController {

	// 路径参数{name}填入用户名，{pass}填入密码。我们设置为GET请求。
	@RequestMapping(value = "/login_get.json/{name}/{pass}", method = RequestMethod.GET)
	// 先前介绍过，就不再介绍了。
	@ResponseBody
	// 当使用@RequestMapping URI template 样式映射时， 即 /login_get.json/{name}/{pass},
	// 这时的name和pass可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
	public Object login(@PathVariable String name, @PathVariable String pass) {
		// 我们这里为了简单就不去数据库查询了（真正开发时候这里就要把传过来的用户名和密码带到数据库里进行查询）
		// 假如我们数据库里用户名是admin密码为123456
		if (name.equals("admin") && pass.equals("123456")) {
			// 到了这里就说明我们登录成功了，这时候我们就要给Android端返回这个用户的信息
			// 这里我们也就先写假数据了
			UserEntity entity = new UserEntity();
			entity.setUsername("admin");
			entity.setPassword("123456");
			entity.setNickname("张三");
			entity.setGender("男");
			entity.setAge("22");

			return entity;// 此时返回此用户实体类
		} else {
			Map map = new HashMap();
			map.clear();
			map.put("msg", "登录失败");
			UserEntity entity = new UserEntity();
			entity.setUsername("admin");
			entity.setGender("男");
			map.put("data", entity);
			return map;// 登录失败给Android端返回一个错误消息提醒用户
		}

	}

}
