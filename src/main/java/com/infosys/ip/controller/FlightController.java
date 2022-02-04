package com.infosys.ip.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.infosys.ip.model.SearchFlights;

@Controller
public class FlightController {
	@Autowired
	private Environment environment;
	private final RestTemplate restTemplate;

	public FlightController(RestTemplateBuilder restTemplateBuilder) {
		System.out.println("enter");
		this.restTemplate = restTemplateBuilder.build();

	}

	@PostMapping(value = "/searchFlights")
	public ModelAndView flightSearch(@Valid @ModelAttribute("command") SearchFlights searchFlights,
			BindingResult bindingResult, ModelMap model) {

		if(false) {
			System.out.println("in If");
		}
		else if(true) {
			System.out.println("in If");
		}
		else {
			System.out.println("aaaa");
			}

		System.out.println("Git Test");
		if(true) {
			System.out.println("in If");
		}
		else {
			System.out.println("in else");

		}
		String restUrl = environment.getProperty("RestUrl");
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			new ModelAndView("searchFlights", "command", searchFlights);
		}
		return modelAndView;

	}
		

		@PostMapping(value = "/searchTrain")
		public ModelAndView trainSearch(@Valid @ModelAttribute("command") SearchFlights searchFlights,
				BindingResult bindingResult, ModelMap model) {
			System.out.println("Git Test");
			if(true) {
				System.out.println("in If");
			}
			else {
				System.out.println("in else");
			}
			System.out.println("AAA");
			String restUrl = environment.getProperty("RestUrl");
			ModelAndView modelAndView = null;
			if (bindingResult.hasErrors()) {
				new ModelAndView("searchFlights", "command", searchFlights);
			}
			return modelAndView;
		}
		
	@PostMapping(value = "/searchFlights")
	public ModelAndView CarSearch(@Valid @ModelAttribute("command") SearchFlights searchFlights,
			BindingResult bindingResult, ModelMap model) {

		String restUrl = environment.getProperty("RestUrl");
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			new ModelAndView("searchFlights", "command", searchFlights);
		}
		return modelAndView;
		}
	@PostMapping(value = "/Flights")
	public ModelAndView VehicalSearch(@Valid @ModelAttribute("command") SearchFlights searchFlights,
			BindingResult bindingResult, ModelMap model) {

		String restUrl = environment.getProperty("RestUrl");
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			new ModelAndView("searchFlights", "command", searchFlights);
		}
		return modelAndView;}
}
@PostMapping(value = "/Flights")
public ModelAndView Search(@Valid @ModelAttribute("command") SearchFlights searchFlights,
		BindingResult bindingResult, ModelMap model) {

	String restUrl = environment.getProperty("RestUrl");
	ModelAndView modelAndView = null;
	if (bindingResult.hasErrors()) {
		new ModelAndView("searchFlights", "command", searchFlights);
	}
	return modelAndView;}
}
	