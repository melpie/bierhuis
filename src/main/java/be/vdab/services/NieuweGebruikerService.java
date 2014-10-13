package be.vdab.services;

import java.util.Set;

import be.vdab.entities.Authority;
import be.vdab.entities.User;

public interface NieuweGebruikerService {

	void voegGebruikerToe(Set<Authority> authorities, User user);

}