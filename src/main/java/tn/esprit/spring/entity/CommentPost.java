package tn.esprit.spring.entity;

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
public class CommentPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // clé primaire

	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date date;

	private String text;

	// chaque comment associer a un seul poste
	@ManyToOne(fetch = FetchType.EAGER)
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

}
