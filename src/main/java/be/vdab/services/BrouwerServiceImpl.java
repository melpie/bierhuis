package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional
class BrouwerServiceImpl implements BrouwerService {
	private final BrouwerDAO brouwerDAO;

	@Autowired
	BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
		this.brouwerDAO = brouwerDAO;
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}

	@Override
	public Brouwer read(long id) {
		return brouwerDAO.findOne(id);
	}

	@Override
	public void update(Brouwer brouwer) {
		brouwerDAO.save(brouwer);
	}

	@Override
	public void delete(long id) {
		brouwerDAO.delete(id);
	}

	@Override
	public Iterable<Brouwer> findAll() {
		return brouwerDAO.findAll(new Sort("naam"));
	}

	@Override
	public long findAantalBrouwers() {
		return brouwerDAO.count();
	}
}