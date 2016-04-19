package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.UserService;

@Controller
public class MessageController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/message")
	public String friend(Model model) {
		model.addAttribute("users", userService.getAll());
		return "message";
	}
	
}
