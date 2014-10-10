package be.vdab.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bier;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BierAantal;

@Controller
@RequestMapping("/bieren")
class BierController {
	private static final String BIEREN_VIEW = "bieren";
	private static final String BIER_VIEW = "bier";

	private final BierService bierService;

	@Autowired
	BierController(BierService bierService) {
		this.bierService = bierService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BIEREN_VIEW, "bieren", bierService.findAllOrderByAlcohol(new BigDecimal(0), new BigDecimal(100)));
	}
	
	@RequestMapping(value = "{bierid}", method = RequestMethod.GET)
	ModelAndView findByBier(@PathVariable long bierid) {
		Bier bier = bierService.read(bierid);	
		if (bier == null) {
			return new ModelAndView(BIER_VIEW, "fout","Kies een bestaand bier!!!");
		} else {
			BierAantal bierAantal = new BierAantal();
			bierAantal.setBierId(bier.getId());
			return new ModelAndView(BIER_VIEW, "bier", bierService.read(bierid)).addObject("bierAantal",bierAantal);
		}
	}	

}