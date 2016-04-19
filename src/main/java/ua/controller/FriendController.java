package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.FriendService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendService;

	@RequestMapping("/friend")
	public String friend(Model model, Principal principal) {
		model.addAttribute("friends", friendService.showFriend(principal));
		return "friend";
	}
	
	@Transactional
	@RequestMapping("/acceptToFriend/{id}")
	public String addToFriend(@PathVariable int id){
		friendService.addToFriend(id);
		return "redirect:/profile/" + id; 
	}
	
	
}
