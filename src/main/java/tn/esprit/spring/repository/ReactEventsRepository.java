package tn.esprit.spring.repository;

import java.util.List;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.ReactEvents;

public interface ReactEventsRepository extends JpaRepository<ReactEvents, Integer>{
	
	@Query(value = "SELECT * FROM react_events" ,
			nativeQuery = true)
	
	public List <ReactEvents> Afficher ();
	
	
	@Query(value = "SELECT E.name_events , R.react , U.name , U.lastname FROM react_events R , user U , events E WHERE ( R.users_id = U.id ) AND ( R.events_id_events = E.id_events ) " ,
			nativeQuery = true)
	
	public List <Map<ReactEvents,User>> AfficherAll ();
	
	
	@Query(value = "SELECT E.name_events , R.react , U.name , U.lastname FROM react_events R , user U , events E WHERE ( R.users_id = U.id ) AND (E.id_events = R.events_id_events) AND (E.id_events = ?1)  " ,
			nativeQuery = true)
	public List <Map<ReactEvents,User>> AfficherReactDetails (int keyword);
	
	/*@Query(value = "SELECT * FROM `react_events` WHERE events_id_events = ?1 " ,
			nativeQuery = true)*/
	
	/*@Query(value = "SELECT R.react , U.first_name , U.last_name FROM react_events R , user U WHERE ( R.users_id_user = U.id_user ) AND ( R.events_id_events = ?1 )",
	nativeQuery = true)
	public List <Map<ReactEvents,User>> AfficherReactDetails (int keyword);
	"INSERT INTO `react_events`(`id_react`, `react`, `events_id_events`, `users_id_user`) SELECT 4 , 'interessee' , 2, 2 FROM events E , user U WHERE ( E.id_events = 2 ) AND ( U.id_user = 2) ");
	 */
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE events E SET E.interested = (SELECT COUNT(react) FROM react_events WHERE (react LIKE 'INTERESSE') AND (E.id_events = events_id_events))" ,
			nativeQuery = true)
	//
	public void SetInteresstedReact ();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE events E SET E.participates = (SELECT COUNT(react) FROM react_events WHERE (react LIKE 'PARTICIPATE') AND (E.id_events = events_id_events))" ,
			nativeQuery = true)
	//
	public void SetParticipateReact ();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE events E SET E.not_interested = (SELECT COUNT(react) FROM react_events WHERE (react LIKE 'Not_INTERESSTED') AND (E.id_events = events_id_events))" ,
			nativeQuery = true)
	//
	public void SetNotInteresstedReact  ();
	
	@Query(value = "SELECT U.email FROM react_events R , user U WHERE (R.react LIKE 'PARTICIPATE') AND (R.users_id = U.id) AND (U.id = ?1)",nativeQuery = true)
	public String getEmailbyReact (int keyword);
	
	@Query(value = "SELECT users_id FROM `react_events` WHERE id_react = ?1 " ,
			nativeQuery = true)
	
	public int getIduserByReact (int keyword);
	
	
}
