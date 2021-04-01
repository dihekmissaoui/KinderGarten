package tn.esprit.spring.service;
import java.util.Map;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.Events;

public interface IEvents {

	List<Events> getAll();
	
	Events save(Events e);
	
	Events saveE(Events e);

	void remove(int IdEvents);

	Events update(int IdEvents , Events events);

	Optional<Events> getById(int IdEvents);
    
	List <Map<Events,Object>> search (String keyword);
	
	List <Map<Events,Object>> ShowAllEvents ();
	
	 int getIduserByEvent (int keyword);
	
}
