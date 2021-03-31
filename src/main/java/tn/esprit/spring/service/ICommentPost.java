package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.CommentPost;

public interface ICommentPost {

	List<CommentPost> list();

	CommentPost save(CommentPost c);

	void remove(int idpostcomment);

	CommentPost updatecommnentPost(int idpostcomment, CommentPost comment);

	Optional<CommentPost> getById(int idpostcomment);
	
     void likeCommentPost (int id);
	
	void dislikeCommentPost (int id);
	
}
