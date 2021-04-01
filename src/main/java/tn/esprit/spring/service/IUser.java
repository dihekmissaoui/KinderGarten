package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import tn.esprit.spring.entity.User;

public interface IUser {
	
	List<User> getAll();
	
	User save(User u);

	void remove(int IdUser);

	Optional<User> getById(int IdUser);
	
	List  <Map<User,Object>> getDirector ();
	
	List <Map<User,Object>> getDirectorbyId (int keyword);
	
	List <Map<User,Object>> getDirectorByIdE (int keyword);
	 
	User findUserByEmail(String email);
	
	String findEmailByID (int keyword);

	void SetNotifEvents(int keyword);
	
	void SetNotifisRead  (int keywords);
	
}
