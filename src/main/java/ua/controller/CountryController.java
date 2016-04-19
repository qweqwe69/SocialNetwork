package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping("/country")
	public String show(Model model) {
		model.addAttribute("countries", countryService.getAll());
		return "country";
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public String save(@RequestParam(value = "nameCountry") String nameCountry) {
		countryService.save(nameCountry);
		return "redirect:/country";
	}

	@RequestMapping("country/{id}")
	public String delete(@PathVariable String id) {
		try {
			int ids = Integer.parseInt(id);
			countryService.delete(ids);
			return "redirect:/country";
		} catch (NumberFormatException e) {
		}
		return "redirect:/country";
	}

}
