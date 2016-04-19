package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.FirstNameService;

@Controller	
public class FirstNameController {
	
	@Autowired
	private FirstNameService firstNameService;
	
	@RequestMapping("/firstname")
	public String show(Model model){
		model.addAttribute("firstnames", firstNameService.getAll());
		return "firstname";
	}
	
	@RequestMapping(value = "/firstname", method = RequestMethod.POST)
	public String save(@RequestParam(value = "nameUser") String nameUser){
		firstNameService.save(nameUser);
		return "redirect:/firstname";
	}
	
	@RequestMapping("firstname/{id}")
	public String delete(@PathVariable int id) {
		firstNameService.delete(id);
		return "redirect:/firstname";
	}
}
