package com.huifu.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huifu.auth.service.UserService;
import com.huifu.auth.support.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/editPrompt")
	public String addPrompt() {
		return "auth/user-edit";
	}

	@RequestMapping("/editPrompt/{uid}")
	public String editPrompt(Model model, @PathVariable("uid") Long uid, UserVO vo) {
		model.addAttribute("uid", uid);
		return "auth/user-edit";
	}

	@RequestMapping("/add")
	public String addUser(Model model, UserVO vo) {
		userService.save(vo);
		return "auth/user-list";
	}
	
}
