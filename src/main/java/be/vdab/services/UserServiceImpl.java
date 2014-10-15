package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.UserDAO;
import be.vdab.entities.User;

@Service
@Transactional
class UserServiceImpl implements UserService {
	private final UserDAO userDAO;

	@Autowired
	UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public User read(String username) {
		return userDAO.findOne(username);
	}


}