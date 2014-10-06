package be.vdab.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;

public interface BierDAO extends JpaRepository<Bier, Long> {
	public Iterable<Bier> findByAlcoholBetweenOrderByAlcoholAsc(BigDecimal van, BigDecimal tot);
	public Iterable<Bier> findByBrouwerIsOrderByNaamAsc(Brouwer brouwer);
}