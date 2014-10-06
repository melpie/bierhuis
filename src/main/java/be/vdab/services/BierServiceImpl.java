package be.vdab.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true)
class BierServiceImpl implements BierService {
	private final BierDAO bierDAO;

	@Autowired
	BierServiceImpl(BierDAO bierDAO) {
		this.bierDAO = bierDAO;
	}

	@Override
	public void create(Bier bier) {
		bierDAO.save(bier);
	}

	@Override
	public Bier read(long id) {
		return bierDAO.findOne(id);
	}

	@Override
	public void update(Bier bier) {
		bierDAO.save(bier);
	}

	@Override
	public void delete(long id) {
		bierDAO.delete(id);
	}

	@Override
	public Iterable<Bier> findAll() {
		return bierDAO.findAll(new Sort("naam"));
	}
	
	@Override
	public Iterable<Bier> findAllOrderByAlcohol(BigDecimal van, BigDecimal tot) {
		return bierDAO.findByAlcoholBetweenOrderByAlcoholAsc(van, tot);
	}
	
	@Override
	public Iterable<Bier> findByBrouwer(Brouwer brouwer) {
		return bierDAO.findByBrouwerIsOrderByNaamAsc(brouwer);
	}

	@Override
	public long findAantalBieren() {
		return bierDAO.count();
	}
}