package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.SoortDAO;
import be.vdab.entities.Soort;

@Service
@Transactional
class SoortServiceImpl implements SoortService {
	private final SoortDAO soortDAO;

	@Autowired
	SoortServiceImpl(SoortDAO soortDAO) {
		this.soortDAO = soortDAO;
	}

	@Override
	public Soort read(long id) {
		return soortDAO.findOne(id);
	}
	
}