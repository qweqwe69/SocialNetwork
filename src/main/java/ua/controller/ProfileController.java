package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.User;
import ua.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/profile")
	public String showCabinet(Principal principal) {
		if (principal != null) {
			if(principal.getName().equals("0")){
				return "redirect:/admin";
			}
			return "redirect:/profile/" + principal.getName();
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/profile/{userId}")
	public String showCabinetName(Model model, @PathVariable int userId){
		User owner = userService.findById(userId);
		if(owner == null){
			return "redirect:/";
		}
		model.addAttribute(owner);
		return "profile";
	}
}
