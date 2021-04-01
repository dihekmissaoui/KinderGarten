package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import tn.esprit.spring.entity.User;


@Entity
@Table(name="events")
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdEvents;
	
	private String NameEvents;
	
	@Temporal(TemporalType.DATE) 
	private Date DateEvents;
	
	private String DescriptionEvents ;
	
	@Lob
    @Column(name="AfficheEvents", length = 1000)
    private byte[] AfficheEvents;

	@OneToMany(mappedBy = "events" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommentEvents> commentsevents = new ArrayList<>();
	
	private int participates ;
	private int interested ;
	private int Not_interested ;
	
	
	@OneToMany(mappedBy = "events" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List <ReactEvents> reacts = new ArrayList<>();
	
	@ManyToOne
	private User user;
		
	
	public int getIdEvents() {
		return IdEvents;
	}

	public void setIdEvents(int idEvents) {
		IdEvents = idEvents;
	}

	public String getNameEvents() {
		return NameEvents;
	}

	public void setNameEvents(String nameEvents) {
		NameEvents = nameEvents;
	}

	public Date getDateEvents() {
		return DateEvents;
	}

	public void setDateEvents(Date dateEvents) {
		DateEvents = dateEvents;
	}

	public String getDescriptionEvents() {
		return DescriptionEvents;
	}

	public void setDescriptionEvents(String descriptionEvents) {
		DescriptionEvents = descriptionEvents;
	}

	public byte[] getAfficheEvents() {
		return AfficheEvents;
	}
	
	public void setAfficheEvents(byte[] afficheEvents) {
		AfficheEvents = afficheEvents;
	}
	public List<CommentEvents> getCommentsevents() {
		return commentsevents;
	}

	public void setCommentsevents(List<CommentEvents> commentsevents) {
		this.commentsevents = commentsevents;
	}
	
	public int getParticipates() {
		return participates;
	}

	public void setParticipates(int participates) {
		this.participates = participates;
	}

	public int getInterested() {
		return interested;
	}

	public void setInterested(int interested) {
		this.interested = interested;
	}

	public int getNot_interested() {
		return Not_interested;
	}

	public void setNot_interested(int not_interested) {
		Not_interested = not_interested;
	}

	public List<ReactEvents> getReacts() {
		return reacts;
	}

	public void setReacts(List<ReactEvents> reacts) {
		this.reacts = reacts;
	}
	

	public Events() {
		super();
	}

	public Events(String nameEvents, Date dateEvents, String descriptionEvents) {
		super();
		NameEvents = nameEvents;
		DateEvents = dateEvents;
		DescriptionEvents = descriptionEvents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Events(int idEvents, String nameEvents, Date dateEvents, String descriptionEvents, byte[] afficheEvents,
			List<CommentEvents> commentsevents, int participates, int interested, int not_interested,
			List<ReactEvents> reacts, User user) {
		super();
		IdEvents = idEvents;
		NameEvents = nameEvents;
		DateEvents = dateEvents;
		DescriptionEvents = descriptionEvents;
		AfficheEvents = afficheEvents;
		this.commentsevents = commentsevents;
		this.participates = participates;
		this.interested = interested;
		Not_interested = not_interested;
		this.reacts = reacts;
		this.user = user;
	}
	
	
}
