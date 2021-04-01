package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Events;

public interface EventsRepository  extends JpaRepository<Events, Integer>{
	
	@Query(value = "SELECT * FROM events WHERE MATCH (name_events , description_events) AGAINST (?1)" ,
			nativeQuery = true)
	
	public List <Map<Events,Object>> search (String keyword);
	
	
	@Query(value = "SELECT `affiche_events`, `date_events`, `description_events`, `name_events`, `not_interested`, `interested`, `participates` FROM `events`" ,
			nativeQuery = true)
	
	public List <Map<Events,Object>> ShowAllEvents ();
	
	@Query(value = "SELECT user_id FROM events WHERE id_events = ?1",nativeQuery = true)
	public int getIduserByEvent (int keyword);
	

}
