package tn.esprit.spring.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class CommentEvents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdCommentEvents;
	
	@Temporal(TemporalType.DATE) 
	private Date dateCommentEvents;
	
	private String Commentaire; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "events_id_events", nullable = false)
	private Events events;

	@ManyToOne
	private User users;

	public CommentEvents() {
		super();
		
	}
	
	public CommentEvents(int idCommentEvents, Date dateCommentEvents, String commentaire) {
		super();
		this.IdCommentEvents = idCommentEvents;
		this.dateCommentEvents = dateCommentEvents;
		this.Commentaire = commentaire;
		//this.events = events;
	}
	
	
	public int getIdCommentEvents() {
		return IdCommentEvents;
	}

	public void setIdCommentEvents(int idCommentEvents) {
		IdCommentEvents = idCommentEvents;
	}

	public Date getDateCommentEvents() {
		return dateCommentEvents;
	}

	public void setDateCommentEvents(Date dateCommentEvents) {
		this.dateCommentEvents = dateCommentEvents;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public CommentEvents(int idCommentEvents, Date dateCommentEvents, String commentaire, Events events, User users) {
		super();
		IdCommentEvents = idCommentEvents;
		this.dateCommentEvents = dateCommentEvents;
		Commentaire = commentaire;
		this.events = events;
		this.users = users;
	}

	
	
	
	
}
