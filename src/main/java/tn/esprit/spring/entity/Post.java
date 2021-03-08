package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// clé primaire
	private String title;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date date;
	private String content;

	// chaque poste a plusieur comment
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "post", orphanRemoval = true)
	private List<CommentPost> comments = new ArrayList<>();

	public Post() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<CommentPost> getComments() {
		return comments;
	}

	public void setComments(List<CommentPost> comments) {
		this.comments = comments;
	}

	public void addComment(CommentPost comment) {
		this.comments.add(comment);
		comment.setPost(this);
	}

	public void removeComment(CommentPost comment) {
		comment.setPost(null);
		this.comments.remove(comment);
	}

}
