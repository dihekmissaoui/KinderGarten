package tn.esprit.spring.service;

import tn.esprit.spring.entity.*;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PostForum}.
 */
public interface PostForumService {

    /**
     * Save a postForum.
     *
     * @param postForum the entity to save.
     * @return the persisted entity.
     */
    PostForum save(PostForum postForum);

    /**
     * Get all the postForums.
     *
     * @return the list of entities.
     */
    List<PostForum> findAll();


    /**
     * Get the "id" postForum.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PostForum> findOne(Long id);

    /**
     * Delete the "id" postForum.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
