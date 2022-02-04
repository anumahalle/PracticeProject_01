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
		@SuppressWarnings("unchecked")
		List<com.infosys.ip.model.SearchFlights> availableFlights = restTemplate
				.getForObject(restUrl + "/FlightAPI/" + searchFlights.getSource() + "/" + searchFlights.getDestination()
						+ "/" + searchFlights.getJourneyDate(), List.class);
		List<String> sources = restTemplate.getForObject(restUrl + "/FlightAPI/source", List.class);
		List<String> destinations = restTemplate.getForObject(restUrl + "/FlightAPI/destination", List.class);
		model.addAttribute("availableFlights", availableFlights);
		model.addAttribute("size", availableFlights.size());
		modelAndView = new ModelAndView("searchFlights", "command", searchFlights);
		modelAndView.addObject("sourceList", sources);
		modelAndView.addObject("destinationList", destinations);
		return modelAndView;
	}
}