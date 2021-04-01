package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.CommentPost;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.CommentEventsRepository;

@Service
public class CommentEventsServiceImpl implements ICommentEvents {
	
	@Autowired
	CommentEventsRepository commenteventsrepository;
	
	@Override
	public List<CommentEvents> getAll() {
		return (List<CommentEvents>) this.commenteventsrepository.findAll();
	}

	@Override
	public CommentEvents save(CommentEvents c) {
		return this.commenteventsrepository.save(c);
	}

	@Override
	public void remove(int IdCommentEvents) {
		this.commenteventsrepository.deleteById(IdCommentEvents);
		
	}

	@Override
	public CommentEvents updatecommnentEvents(int IdCommentEvents, CommentEvents comment) {
		CommentEvents updatecommnentEvents = null;
		Optional<CommentEvents> commantaire = this.commenteventsrepository.findById(IdCommentEvents);
		if (commantaire.isPresent()) {
			CommentEvents upcommant = commantaire.get();
			upcommant = comment;
			updatecommnentEvents = this.commenteventsrepository.save(upcommant);
		}
		return updatecommnentEvents;
	}

	@Override
	public Optional<CommentEvents> getById(int IdCommentEvents) {
		return this.commenteventsrepository.findById(IdCommentEvents);
	}

	@Override
	public List<Map<CommentEvents, User>> AfficherAllComments() {
		// TODO Auto-generated method stub
		return this.commenteventsrepository.AfficherAllComments() ;
	}

	@Override
	public List<Map<CommentEvents, User>> AfficherEventsComments(int keyword) {
		// TODO Auto-generated method stub
		return this.commenteventsrepository.AfficherEventsComments(keyword) ;
	}

	@Override
	public CommentEvents AddComment(CommentEvents com) {
		// TODO Auto-generated method stub
		return this.commenteventsrepository.AddComment(com);
	}

	@Override
	public int getIdEventByC(int keyword) {
		// TODO Auto-generated method stub
		return commenteventsrepository.getIdEventByC(keyword);
	}

	@Override
	public List<Map<CommentEvents, User>> getComByD(int keyword) {
		// TODO Auto-generated method stub
		return commenteventsrepository.getComByD(keyword);
	}

}
