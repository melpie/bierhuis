package be.vdab.services;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	void create(Brouwer brouwer);

	Brouwer read(long id);

	void update(Brouwer brouwer);

	void delete(long id);

	Iterable<Brouwer> findAll();

	long findAantalBrouwers();
}