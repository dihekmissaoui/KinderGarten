package tn.esprit.spring.entity;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Reference;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="react_events")
public class ReactEvents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int IdReact;
	
	private String react;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	//@JoinColumn(name = "events_id_events")
	private Events events;

	@ManyToOne
	private User users;

	public int getIdReact() {
		return IdReact;
	}

	public void setIdReact(int idReact) {
		IdReact = idReact;
	}

	public String getReact() {
		return react;
	}

	public void setReact(String react) {
		this.react = react;
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

	public ReactEvents() {
		super();
	}

	public ReactEvents(int idReact, String react, Events events, User users) {
		super();
		IdReact = idReact;
		this.react = react;
		this.events = events;
		this.users = users;
	}

	public ReactEvents(String react, User users) {
		super();
		this.react = react;
		this.users = users;
	}

	
	
}
