package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.FollowerService;

@Controller
public class FollowerController {
	
	@Autowired
	private FollowerService followerService;
	
	@RequestMapping("/followers")
	public String friend(Principal principal, Model model) {
		model.addAttribute("appFriends", followerService.showFollowers(principal));
		return "followers";
	}
}
