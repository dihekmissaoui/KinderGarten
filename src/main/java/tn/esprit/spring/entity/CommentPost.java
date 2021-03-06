package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")// pour afficher le post du comment
public class CommentPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // clé primaire

	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date date;

	private String text;
	
	private int likes ;
	private int dislikes ;

	// chaque comment associer a un seul poste
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonBackReference
	private Post post;

	public CommentPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentPost(int id, Date date, String text, int idPost) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
	}
	

	public CommentPost(int id, Date date, String text, int likes, int dislikes, Post post) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
		this.likes = likes;
		this.dislikes = dislikes;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

}
