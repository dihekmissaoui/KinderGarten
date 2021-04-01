package tn.esprit.spring.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;

public interface CommentEventsRepository extends CrudRepository<CommentEvents, Integer> {
	
	
	@Query(value = "SELECT E.name_events , U.name , U.lastname , C.commentaire FROM comment_events C , events E , user U WHERE (E.id_events = C.events_id_events) AND (U.id = C.users_id)",
			nativeQuery = true)
	public List <Map<CommentEvents,User>> AfficherAllComments ();

	
	@Query(value = "SELECT E.name_events , U.name , U.lastname , C.commentaire FROM comment_events C , events E , user U WHERE (E.id_events = C.events_id_events) AND (U.id = C.users_id) AND (E.id_events = ?1)", nativeQuery = true)
	public List <Map<CommentEvents,User>> AfficherEventsComments (int keyword);

	@Query(value = "INSERT INTO `comment_events`(`id_comment_events`, `commentaire`, `date_comment_events`, `events_id_events`, `users_id`) VALUES (?1,?2,?3,?4,?5)", nativeQuery = true)
	
	public CommentEvents AddComment (CommentEvents com);
	
	@Query(value = "SELECT events_id_events FROM `comment_events` WHERE id_comment_events = ?1 ", nativeQuery = true)
	public int getIdEventByC(int keyword);
	
	@Query(value = "SELECT E.name_events ,U.name ,U.lastname ,C.commentaire FROM comment_events C , events E , user U WHERE (E.id_events = C.events_id_events)AND(C.users_id = U.id) AND (E.user_id = ?1)", nativeQuery = true)
	public List <Map<CommentEvents,User>> getComByD (int keyword);

}
