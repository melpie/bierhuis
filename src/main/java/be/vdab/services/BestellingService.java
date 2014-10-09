package be.vdab.services;

import java.util.Set;

import be.vdab.entities.BestelBon;
import be.vdab.entities.BestelBonLijn;

public interface BestellingService {

	void doeBestelling(Set<BestelBonLijn> bestelBonLijnen, BestelBon bestelBon);

}