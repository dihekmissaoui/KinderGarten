package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.PostRepository;

@Service
public class PostServiceImpl implements IPostService {
	// injection du repository
	@Autowired
	PostRepository postrepository;



	@Override
	public List<Post> list() {
		return (List<Post>) this.postrepository.findAll();
	}

	@Override
	public Post save(Post p) {
		return this.postrepository.save(p);
	}

	@Override
	public void remove(int id) {
		this.postrepository.deleteById(id);

	}

	@Override
	public Post updatePost(int id, Post p) {
		Post updatedpost = null;
		Optional<Post> searchPost = this.postrepository.findById(id);
		if (searchPost.isPresent()) {
			Post finded = searchPost.get();
			finded = p;
			updatedpost = this.postrepository.save(finded);
		}
		return updatedpost;
	}

	@Override
	public Optional<Post> getById(int id) {
		return this.postrepository.findById(id);
	}

}
