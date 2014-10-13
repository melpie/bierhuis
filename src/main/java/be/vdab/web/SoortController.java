package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Soort;
import be.vdab.services.BierService;
import be.vdab.services.SoortService;

@Controller
@RequestMapping("/soort")
class SoortController {
	private static final String BIEREN_PER_SOORT_VIEW = "bierenpersoort";

	private final SoortService soortService;
	private final BierService bierService;

	@Autowired
	SoortController(SoortService soortService, BierService bierService) {
		this.soortService = soortService;
		this.bierService = bierService;
	}
		
	@RequestMapping(value = "{soortid}", method = RequestMethod.GET)
	ModelAndView findBySoort(@PathVariable long soortid) {
		Soort soort = soortService.read(soortid);	
		if (soort == null) {
			return new ModelAndView(BIEREN_PER_SOORT_VIEW, "fout","Kies een bestaande soort!!!");
		} else {
			return new ModelAndView(BIEREN_PER_SOORT_VIEW, "bieren", bierService.findBySoort(soort)).addObject("soort",soort);
		}
	}

}