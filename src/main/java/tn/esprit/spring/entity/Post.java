package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idPost ;// clé primaire
	private int iduser ;
	private String title ;
	@Column(name = "date")
	@Temporal(TemporalType.DATE)      // pour avoir le type de date 
	private Date date;
	private String content ;
	
	@ManyToOne
	private User user;
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Post(int idPost, String title, Date date, String content, Id id) {
		super();
		this.idPost = idPost;
		this.title = title;
		this.date = date;
		this.content = content;
		//this.id = id;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
}
