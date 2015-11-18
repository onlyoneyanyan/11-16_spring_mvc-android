package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.UserEntity;

//这一步肯定少不了，前面有介绍就不再介绍了 
@Controller
// 定义访问注册接口的父路径，前面有介绍也不多介绍了
@RequestMapping("RegisteredController")
public class RegisteredController {
	// 由于是提交数据所以我们这里使用POST请求
	@RequestMapping(value = "/registered_post.json", method = RequestMethod.POST)
	@ResponseBody
	// 此处@ModelAttribute 可以吧POST请求所携带的json字符串自动解析成后面所写的实体类
	// ，然后就直接可以通过这个UserEntity取到Android端传过来的数据
	public Object registered(@ModelAttribute UserEntity entity) {
		String username = entity.getUsername();
		String password = entity.getPassword();
		String nickname = entity.getNickname();
		String gender = entity.getGender();
		String age = entity.getAge();
		// 现在数据已经拿到了（真正开发时候我们需要把这里Android传回来用户登记的数据插入到数据库中就好了）
		// 为了方便查看,所以这里我把返回的数据拼到一起了
		String string = "用户名：" + username + " - 密码：" + password + " - 昵称：" + nickname + " - 性别：" + gender + " - 年龄："
				+ age;
		// 如果数据库插入成功然后返回true，再给Android返回一个消息，告诉Android端已经注册成功，可以进行登录了
		// 这里没有涉及到数据库操作，所以这里我们这里简单判断一下数据不为null就证明注册成功了
		if (username != null && password != null && nickname != null && gender != null && age != null) {
			// 成功返回消息告诉Android端
			Map<String, String> map = new HashMap<String, String>();
			map.put("msg", "注册成功！");
			return map;
		} else {
			// 失败返回消息告诉Android端
			Map<String, String> map = new HashMap<String, String>();
			map.put("msg", "注册失败！");
			return map;
		}
	}
}
