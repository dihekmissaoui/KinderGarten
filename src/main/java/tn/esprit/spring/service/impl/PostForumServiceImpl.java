package tn.esprit.spring.service.impl;

import tn.esprit.spring.repository.PostForumRepository;
import tn.esprit.spring.service.PostForumService;

import tn.esprit.spring.entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link PostForum}.
 */
@Service
@Transactional
public class PostForumServiceImpl implements PostForumService {

    private final Logger log = LoggerFactory.getLogger(PostForumServiceImpl.class);

    private final PostForumRepository postForumRepository;

    public PostForumServiceImpl(PostForumRepository postForumRepository) {
        this.postForumRepository = postForumRepository;
    }

    @Override
    public PostForum save(PostForum postForum) {
        log.debug("Request to save PostForum : {}", postForum);
        return postForumRepository.save(postForum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostForum> findAll() {
        log.debug("Request to get all PostForums");
        return postForumRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PostForum> findOne(Long id) {
        log.debug("Request to get PostForum : {}", id);
        return postForumRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PostForum : {}", id);
        postForumRepository.deleteById(id);
    }
}
