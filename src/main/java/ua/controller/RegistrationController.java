package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.editor.CityEditor;
import ua.editor.FirstNameEditor;
import ua.entity.City;
import ua.entity.FirstName;
import ua.entity.User;
import ua.service.CityService;
import ua.service.FirstNameService;
import ua.service.RegistrationService;
import ua.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private FirstNameService firstNameService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CityService cityService;
	
//	@RequestMapping("/registration")
//	public String show(Model model) {
//		model.addAttribute("registrations", registrationService.getAll());
//		model.addAttribute("cities", cityService.getAll());
//		model.addAttribute("firstnames", firstNameService.getAll());
//		return "registration";
//	}
	
//	@RequestMapping(value = "/registration", method = RequestMethod.POST)
//	public String save(@RequestParam(value = "lastName") String lastName,
//						@RequestParam(value = "email") String email,
//						@RequestParam(value = "password") String password,
//						@RequestParam(value = "phone") String phone,
//						@RequestParam(value = "placeOfWork") String placeOfWork,
//						@RequestParam(value = "cityId")int cityId,
//						@RequestParam(value = "firstnameId")int firstnameId,
//						@RequestParam(value = "sex")String sex,
//						@RequestParam(value = "role",required=false)String role){
//		registrationService.save(lastName, email, password, phone, 
//				placeOfWork, cityId, firstnameId, sex, role);
//		return "redirect:/";
//	}
	
	@InitBinder
	protected void initbinderCityAndFirstName(WebDataBinder binder){
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
		binder.registerCustomEditor(FirstName.class, new FirstNameEditor(firstNameService));
	}
	
	
	
	@RequestMapping("/registration")
	public String qweqwe(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("cities", cityService.getAll());
		model.addAttribute("firstnames", firstNameService.getAll());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
 	public String save(@Valid @ModelAttribute User user, BindingResult result, Model model){
		if (result.hasErrors()){
			model.addAttribute("cities", cityService.getAll());
			model.addAttribute("firstnames", firstNameService.getAll());
			return "registration";
		}
		registrationService.save(user);
		return "redirect:/";
	}
}
