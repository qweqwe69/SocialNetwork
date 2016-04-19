package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CityService;
import ua.service.CountryService;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/city")
	public String show(Model model) {
		model.addAttribute("cities", cityService.getAll());
		model.addAttribute("countries", countryService.getAll());
		return "city";
	}	
	
	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public String save(@RequestParam(value = "nameCity") String nameCity,
			@RequestParam(value = "countryId")int countryId){
		cityService.save(nameCity, countryId);
		return "redirect:/city";
	}
	
	@RequestMapping("city/{id}")
	public String delete(@PathVariable String id) {
		try {
			int ids = Integer.parseInt(id);
			cityService.delete(ids);
			return "redirect:/city";
		} catch (NumberFormatException e) {
		}
		return "redirect:/city";
	}
}
