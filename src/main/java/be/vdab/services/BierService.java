package be.vdab.services;

import java.math.BigDecimal;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;

public interface BierService {
	void create(Bier bier);

	Bier read(long id);

	void update(Bier bier);

	void delete(long id);

	Iterable<Bier> findAll();

	Iterable<Bier> findAllOrderByAlcohol(BigDecimal van, BigDecimal tot);
	
	Iterable<Bier> findByBrouwer(Brouwer brouwer);

	long findAantalBieren();

}