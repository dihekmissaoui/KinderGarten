package tn.esprit.spring.repository.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.esprit.spring.entity.PostForum;
import tn.esprit.spring.entity.PostForumFilter;

public interface PostForumQuery {
Page<PostForum> findPostforumByFilter(PostForumFilter  postForumFilter,Pageable pageable);
}
