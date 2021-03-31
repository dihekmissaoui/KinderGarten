package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Post;

public interface IPostService {
	List<Post> list();

	Post save(Post p);

	void remove(int idPost);

	Post updatePost(int idPost, Post post);

	Optional<Post> getById(int idPost);
      
	void likePost (int id);
	
	void dislikePost (int id);
	
	List<Post> getPostByHighLike();
	
	List<Post> getPostByTitle(String title);
	
	List<Post> getPostWithMaxComments ();

	



	
	
}
