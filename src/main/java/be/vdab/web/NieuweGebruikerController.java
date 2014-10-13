package be.vdab.web;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Authority;
import be.vdab.entities.User;
import be.vdab.services.NieuweGebruikerService;
import be.vdab.valueobjects.AuthorityPK;

@Controller
@RequestMapping(value = "/nieuwegebruiker")
public class NieuweGebruikerController {
	
	private static final String NIEUWEGEBRUIKER_VIEW = "nieuwegebruiker";
	private static final String WELKOM_VIEW = "welkom";
	private final NieuweGebruikerService nieuweGebruikerService;

	@Autowired
	public NieuweGebruikerController(NieuweGebruikerService nieuweGebruikerService) {
		this.nieuweGebruikerService = nieuweGebruikerService;
	}
		
	@RequestMapping(method=RequestMethod.GET)
	ModelAndView toonNieuweGebruikerForm() {
		User user = new User();
		return new ModelAndView(NIEUWEGEBRUIKER_VIEW, "user", user);
	}
	
	@RequestMapping(method=RequestMethod.POST, params={"username", "password", "enabled", "naam", "straat", "huisnummer", "postcode", "gemeente"})
	ModelAndView doeBestelling(@Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView(NIEUWEGEBRUIKER_VIEW, "user", user);
		} 
		
		else {
			Set<Authority> authorities = new LinkedHashSet<Authority>();
			AuthorityPK key = new AuthorityPK("klant",user);
			authorities.add(new Authority(key));
			nieuweGebruikerService.voegGebruikerToe(authorities, user);
			return new ModelAndView(WELKOM_VIEW);
		}
	}

}
