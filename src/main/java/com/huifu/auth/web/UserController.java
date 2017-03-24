package com.huifu.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huifu.auth.service.UserService;
import com.huifu.auth.support.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/addPrompt")
	public String addPrompt() {
		return "auth/user-edit";
	}

	@RequestMapping("/editPrompt")
	public String editPrompt(Model model, UserVO vo) {
		model.addAttribute("userVO", vo);
		return "auth/user-edit";
	}

	@RequestMapping("/add")
	public String addUser(Model model, UserVO vo) {
		userService.save(vo);
		return "auth/user-list";
	}
}
