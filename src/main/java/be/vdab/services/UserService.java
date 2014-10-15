package be.vdab.services;

import be.vdab.entities.User;

public interface UserService {

	User read(String username);

}