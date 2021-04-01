package tn.esprit.spring.repository;

import tn.esprit.spring.entity.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PostForum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PostForumRepository extends JpaRepository<PostForum, Long> {
}
