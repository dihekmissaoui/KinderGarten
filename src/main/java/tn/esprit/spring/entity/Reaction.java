package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.entity.enumeration.ReactionType;

/**
 * A Reaction.
 */
@Entity
@Table(name = "reaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "reaction_type")
    private ReactionType reactionType;

    @ManyToOne
    @JsonIgnoreProperties(value = "reactions", allowSetters = true)
    private PostForum reactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public Reaction reactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
        return this;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public PostForum getReactions() {
        return reactions;
    }

    public Reaction reactions(PostForum postForum) {
        this.reactions = postForum;
        return this;
    }

    public void setReactions(PostForum postForum) {
        this.reactions = postForum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reaction)) {
            return false;
        }
        return id != null && id.equals(((Reaction) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Reaction{" +
            "id=" + getId() +
            ", reactionType='" + getReactionType() + "'" +
            "}";
    }
}
