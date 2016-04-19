package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.editor.CityEditor;
import ua.editor.FirstNameEditor;
import ua.entity.City;
import ua.entity.FirstName;
import ua.entity.User;
import ua.service.CityService;
import ua.service.FirstNameService;
import ua.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private FirstNameService firstNameService;
	
//	@RequestMapping("/user")
//	public String show(Model model) {
//		model.addAttribute("users", userService.getAll());
//		model.addAttribute("cities", cityService.getAll());
//		model.addAttribute("firstnames", firstNameService.getAll());
//		return "user";
//	}
	
//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String save(@RequestParam(value = "lastName") String lastName,
//						@RequestParam(value = "email") String email,
//						@RequestParam(value = "password") String password,
//						@RequestParam(value = "phone") String phone,
//						@RequestParam(value = "cityId")int cityId,
//						@RequestParam(value = "firstnameId")int firstnameId,
//						@RequestParam(value = "sex")String sex){
//		userService.save(lastName, email, password, phone, 
//				 cityId, firstnameId, sex);
//		return "redirect:/user";
//	}
	
	@InitBinder
	protected void initbinderCityAndFirstName(WebDataBinder binder){
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
		binder.registerCustomEditor(FirstName.class, new FirstNameEditor(firstNameService));
	}
	
	@RequestMapping("/user")
	public String qweqwe(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.getAll());
		model.addAttribute("cities", cityService.getAll());
		model.addAttribute("firstnames", firstNameService.getAll());
		return "user";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
 	public String save(@ModelAttribute User user){
		userService.save(user);
		return "redirect:/user";
	}
	

	@RequestMapping("user/{id}")
	public String delete(@PathVariable String id) {
		try {
			int ids = Integer.parseInt(id);
			userService.delete(ids);
			return "redirect:/user";
		} catch (NumberFormatException e) {
		}
		return "redirect:/user";
	}
}
