package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.SearchService;
import ua.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String qweqwe(Model model, Principal principal){
		model.addAttribute("users", userService.getAll());
		model.addAttribute("userId", principal.getName());
		return "search";
	}
	
	@RequestMapping("/addApplicationFriend/{id}")
	public String addAppFriend(Principal principal, @PathVariable int id){
		searchService.addAppFriend(id, principal);
		return "redirect:/profile/" + id;
	}
	
}
