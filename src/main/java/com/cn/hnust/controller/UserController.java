package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.entity.User;
import com.cn.hnust.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model) {
		int userId=Integer.parseInt(request.getParameter("id"));
		User user=this.userService.getUserById(userId);
		model.addAttribute("user",JSON.toJSON(user));
		System.out.println(JSON.toJSON(user));
		return "showUser";
	}
}
