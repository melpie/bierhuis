package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.BestelBonLijn;
import be.vdab.valueobjects.BestelBonLijnPK;

public interface BestelBonLijnDAO extends JpaRepository<BestelBonLijn, BestelBonLijnPK> {

}