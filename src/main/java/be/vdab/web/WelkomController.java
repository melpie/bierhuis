package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
@RequestMapping(value = "/")
class WelkomController {
	private static final String VIEW = "welkom";

	private final BierService bierService;

	@Autowired
	WelkomController(BierService bierService) {
		this.bierService = bierService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index() {
		return new ModelAndView(VIEW, "aantalbieren", bierService.findAantalBieren());
	}
}