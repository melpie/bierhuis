package be.vdab.web;

import java.util.Map;

import be.vdab.entities.Bier;

public interface Winkelwagen {
	
	Map<Bier, Integer> getBierenInMandje();
	void addBier(Bier bier,int aantal);
	
}
