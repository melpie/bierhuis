package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BierService;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers";
	private static final String BIEREN_PER_BROUWER_VIEW = "bierenperbrouwer";

	private final BrouwerService brouwerService;
	private final BierService bierService;

	@Autowired
	BrouwerController(BierService bierService, BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		this.bierService = bierService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}
	
	@RequestMapping(value = "{brouwerid}", method = RequestMethod.GET)
	ModelAndView findByBrouwer(@PathVariable long brouwerid) {
		Brouwer brouwer = brouwerService.read(brouwerid);	
		if (brouwer == null) {
			return new ModelAndView(BIEREN_PER_BROUWER_VIEW, "fout","Kies een bestaande brouwer!!!");
		} else {
			return new ModelAndView(BIEREN_PER_BROUWER_VIEW, "bieren", bierService.findByBrouwer(brouwer)).addObject("brouwer",brouwer);
		}
	}	
	
}