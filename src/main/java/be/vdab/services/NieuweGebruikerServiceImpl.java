package be.vdab.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.AuthorityDAO;
import be.vdab.dao.UserDAO;
import be.vdab.entities.Authority;
import be.vdab.entities.User;

@Service
@Transactional
class NieuweGebruikerServiceImpl implements NieuweGebruikerService {
	private final UserDAO userDAO;
	private final AuthorityDAO authorityDAO;

	@Autowired
	NieuweGebruikerServiceImpl(UserDAO userDAO, AuthorityDAO authorityDAO) {
		this.userDAO = userDAO;
		this.authorityDAO = authorityDAO;
	}
	
	public void voegGebruikerToe(Set<Authority> authorities, User user) {
		
		userDAO.save(user);
		
		for (Authority a : authorities) {
			authorityDAO.save(a);
		}
			
	}

}