package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import tn.esprit.spring.entity.Events;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id ;
	
	@Column(unique= true)
	private String username ;
	
	private String password ;
	
	@Column(unique = true)
	private String email ;
	
	private String phone ; 
	
	private String address ; 
	
	private String name ; 
	
	private String lastname ;
	
	private String photoUrl ;
	
	 @Enumerated( EnumType.STRING)
	private Role role;

		public enum Role {
			
		PARENT,ADMIN,DIRECTOR	
			
		}
		
	private int notifEvents ;

	@OneToMany(mappedBy = "user")
    private List <Events> events = new ArrayList<>();
	
	@OneToMany(mappedBy = "users")
    private List <ReactEvents> reacts = new ArrayList<>();
	
	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List <CommentEvents> com_events = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ReactEvents> getReacts() {
		return reacts;
	}

	public void setReacts(List<ReactEvents> reacts) {
		this.reacts = reacts;
	}

	public List<CommentEvents> getCom_events() {
		return com_events;
	}

	public void setCom_events(List<CommentEvents> com_events) {
		this.com_events = com_events;
	}


	public User(){}

	public int getNotifEvents() {
		return notifEvents;
	}

	public void setNotifEvents(int notifEvents) {
		this.notifEvents = notifEvents;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public User(long id, String username, String password, String email, String phone, String address, String name,
			String lastname, String photoUrl, Role role, int notifEvents, List<Events> events, List<ReactEvents> reacts,
			List<CommentEvents> com_events) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.name = name;
		this.lastname = lastname;
		this.photoUrl = photoUrl;
		this.role = role;
		this.notifEvents = notifEvents;
		this.events = events;
		this.reacts = reacts;
		this.com_events = com_events;
	}

	

	
	

}
