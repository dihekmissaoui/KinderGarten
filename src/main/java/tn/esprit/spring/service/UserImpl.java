package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserImpl implements IUser {
	
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public List<User> getAll(){
		return (List<User>) this.UserRepository.findAll();
	}

	@Override
	public User save(User u) {
		return this.UserRepository.save(u);
	}

	@Override
	public void remove(int IdUser) {
		this.UserRepository.deleteById(IdUser);
		
	}
	
	@Override
	public Optional<User> getById(int IdUser) {

		return this.UserRepository.findById(IdUser);
	}
	/*public boolean addReact (Events e) {
		  
		assertTrue(events.add(e));
	}*/

	@Override
	public List <Map<User,Object>> getDirector() {
		// TODO Auto-generated method stub
		return UserRepository.getDirector();
	}

	@Override
	public List<Map<User, Object>> getDirectorbyId(int keyword) {
		// TODO Auto-generated method stub
		return UserRepository.getDirectorbyId(keyword);
	}

	@Override
	public List <Map<User,Object>> getDirectorByIdE(int keyword) {
		// TODO Auto-generated method stub
		return UserRepository.getDirectorByIdE(keyword);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return UserRepository.findUserByEmail(email);
	}

	@Override
	public String findEmailByID(int keyword) {
		// TODO Auto-generated method stub
		return UserRepository.findEmailByID(keyword);
	}

	@Override
	public void SetNotifEvents (int keyword) {
		// TODO Auto-generated method stub
		UserRepository.SetNotifEvents(keyword);
		
	}

	@Override
	public void SetNotifisRead(int keyword) {
		// TODO Auto-generated method stub
		UserRepository.SetNotifisRead(keyword);
		
	}

	

}
