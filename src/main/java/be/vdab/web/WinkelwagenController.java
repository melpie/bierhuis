package be.vdab.web;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.BestelBon;
import be.vdab.entities.BestelBonLijn;
import be.vdab.entities.Bier;
import be.vdab.services.BestellingService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelBonGegevens;
import be.vdab.valueobjects.BierAantal;

@Controller
@RequestMapping(value = "/winkelwagen")
public class WinkelwagenController {
	
	private static final String WINKELWAGEN_VIEW = "winkelwagen";
	private static final String BEVESTIGING_VIEW = "bevestiging";
	private final Winkelwagen winkelwagen;
	private final BierService bierService;
	private final BestellingService bestellingService;

	@Autowired
	public WinkelwagenController(Winkelwagen winkelwagen, BierService bierService, BestellingService bestellingService) {
		this.winkelwagen = winkelwagen;
		this.bierService = bierService;
		this.bestellingService = bestellingService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	ModelAndView toonWinkelwagen() {
		BestelBonGegevens bestelBonGegevens = new BestelBonGegevens();
		bestelBonGegevens.setNaam("Pieter");
		return new ModelAndView(WINKELWAGEN_VIEW, "winkelwagen", winkelwagen.getBierenInMandje()).addObject("bestelBonGegevens",bestelBonGegevens);
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"aantal", "bierId"})
	ModelAndView voegToeAanMandje(BierAantal bierAantal) {
		winkelwagen.addBier(bierService.read(bierAantal.getBierId()), bierAantal.getAantal());
		BestelBonGegevens bestelBonGegevens = new BestelBonGegevens();
		bestelBonGegevens.setNaam("Pieter");
		return new ModelAndView(WINKELWAGEN_VIEW, "winkelwagen", winkelwagen.getBierenInMandje()).addObject("bestelBonGegevens",bestelBonGegevens);
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"naam", "straat", "huisnummer", "postcode", "gemeente"})
	ModelAndView doeBestelling(BestelBonGegevens bestelBonGegevens) {

		BestelBon bestelBon = new BestelBon(bestelBonGegevens.getNaam(),bestelBonGegevens.getStraat(),bestelBonGegevens.getHuisnummer(),bestelBonGegevens.getPostcode(),bestelBonGegevens.getGemeente());
		
		Map<Bier, Integer> bierenInMandje = winkelwagen.getBierenInMandje();
		Set<BestelBonLijn> bestelBonLijnen = new LinkedHashSet<BestelBonLijn>();
		if (bierenInMandje != null) {
			Iterator<Bier> it = bierenInMandje.keySet().iterator();
			while (it.hasNext()) { 
				Bier bier = it.next(); 
				bestelBonLijnen.add(new BestelBonLijn(bierenInMandje.get(bier),bier,bestelBon));
			}
		}
		
		bestellingService.doeBestelling(bestelBonLijnen, bestelBon);

		return new ModelAndView(BEVESTIGING_VIEW).addObject("bestelBon",bestelBon);
	}

}