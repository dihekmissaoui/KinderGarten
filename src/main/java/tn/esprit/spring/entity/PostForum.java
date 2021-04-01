package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A PostForum.
 */
@Entity
@Table(name = "post_forum")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PostForum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private Instant creationDate;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "reactions")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Reaction> reactions = new HashSet<>();

    @OneToMany(mappedBy = "commentaire")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "postForums", allowSetters = true)
    private Category posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public PostForum title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public PostForum creationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public PostForum content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public PostForum reactions(Set<Reaction> reactions) {
        this.reactions = reactions;
        return this;
    }

    public PostForum addReaction(Reaction reaction) {
        this.reactions.add(reaction);
        reaction.setReactions(this);
        return this;
    }

    public PostForum removeReaction(Reaction reaction) {
        this.reactions.remove(reaction);
        reaction.setReactions(null);
        return this;
    }

    public void setReactions(Set<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public PostForum comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public PostForum addComment(Comment comment) {
        this.comments.add(comment);
        comment.setCommentaire(this);
        return this;
    }

    public PostForum removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setCommentaire(null);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Category getPosts() {
        return posts;
    }

    public PostForum posts(Category category) {
        this.posts = category;
        return this;
    }

    public void setPosts(Category category) {
        this.posts = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PostForum)) {
            return false;
        }
        return id != null && id.equals(((PostForum) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PostForum{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}
