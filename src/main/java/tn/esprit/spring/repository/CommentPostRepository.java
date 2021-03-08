package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.CommentPost;

public interface CommentPostRepository extends CrudRepository<CommentPost, Integer> {

}
