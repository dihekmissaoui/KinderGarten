package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.User;

public interface ICommentEvents {
	
	List<CommentEvents> getAll();

	CommentEvents save(CommentEvents c);

	void remove(int IdCommentEvents);

	CommentEvents updatecommnentEvents(int IdCommentEvents, CommentEvents comment);

	Optional<CommentEvents> getById(int IdCommentEvents);
	
	List <Map<CommentEvents,User>> AfficherAllComments ();

	List <Map<CommentEvents,User>> AfficherEventsComments (int keyword);
	
	CommentEvents AddComment (CommentEvents com);
	
	int getIdEventByC(int keyword);
	
	List <Map<CommentEvents,User>> getComByD (int keyword);
	
}
