package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;

public interface IReactEvents {

	List<ReactEvents> getAll();
	
	ReactEvents save(ReactEvents R);
	
	List <Map<ReactEvents,User>> AfficherReactDetails (int keyword);
	
	List <Map<ReactEvents,User>> getAllReacts ();
	
	void SetInteresstedReact ();
	
	void SetParticipateReact ();
	
	void SetNotInteresstedReact ();
	
	String getEmailbyReact (int keyword);
	
	int getIduserByReact (int keyword);

}
