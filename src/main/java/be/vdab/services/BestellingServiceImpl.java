package be.vdab.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BestelBonDAO;
import be.vdab.dao.BestelBonLijnDAO;
import be.vdab.entities.BestelBon;
import be.vdab.entities.BestelBonLijn;

@Service
@Transactional
class BestellingServiceImpl implements BestellingService {
	private final BestelBonDAO bestelBonDAO;
	private final BestelBonLijnDAO bestelBonLijnDAO;

	@Autowired
	BestellingServiceImpl(BestelBonDAO bestelBonDAO, BestelBonLijnDAO bestelBonLijnDAO) {
		this.bestelBonDAO = bestelBonDAO;
		this.bestelBonLijnDAO = bestelBonLijnDAO;
	}
	
	public void doeBestelling(Set<BestelBonLijn> bestelBonLijnen, BestelBon bestelBon) {
		
		bestelBonDAO.save(bestelBon);
		
		for (BestelBonLijn bbl : bestelBonLijnen) {
			bestelBonLijnDAO.save(bbl);
		}
			
	}

}