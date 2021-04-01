package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT name , lastname FROM `user` WHERE role = 'DIRECTOR' " , nativeQuery = true)
	
	public List <Map<User,Object>> getDirector ();
	
	
	@Query(value = "SELECT name , lastname FROM `user` WHERE role = 'DIRECTOR' AND id = ?1  " , nativeQuery = true)
		
	public List <Map<User,Object>> getDirectorbyId (int keyword);
		
	@Query(value = "SELECT id FROM `user` WHERE role = 'DIRECTOR' AND id = ?1" ,nativeQuery = true)
		
	public List <Map<User,Object>> getDirectorByIdE (int keyword);
		
	User findUserByEmail(String email);
		 
	@Query(value = "SELECT email FROM user WHERE id = ?1 " , nativeQuery = true)
			
	public String findEmailByID (int keyword);
		 
	@Modifying
	@Transactional
	@Query(value = " UPDATE user U SET U.notif_events = U.notif_events + 1 WHERE U.id = ?1 ", nativeQuery = true)
	public void SetNotifEvents  (int keywords);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE user U SET U.notif_events = 0 WHERE U.id = ?1 ",nativeQuery = true)
	public void SetNotifisRead  (int keyword);
	
}
