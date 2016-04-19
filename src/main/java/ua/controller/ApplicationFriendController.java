//package ua.controller;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import ua.service.ApplicationFriendService;
//
//@Controller
//public class ApplicationFriendController {
//	
//	@Autowired
//	private ApplicationFriendService applicationFriendService;
//	
//	@RequestMapping("/addApplicationFriend/{id}")
//	public String addAppFriend(Principal principal, @PathVariable int id){
//		applicationFriendService.addAppFriend(id, principal);
//		return "profile/" + id;
//	}
//}
