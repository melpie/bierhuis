package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.BestelBon;

public interface BestelBonDAO extends JpaRepository<BestelBon, Long> {

}