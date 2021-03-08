package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Post;

public interface IPostService {
	List<Post> list();

	Post save(Post p);

	void remove(int idPost);

	Post updatePost(int idPost, Post post);

	Optional<Post> getById(int idPost);

}
