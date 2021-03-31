package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.likes = p.likes+1 WHERE p.id=:id")
	void likePost(@Param("id") int id);

	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.dislikes = p.likes+1 WHERE p.id=:id")
	void dislikePost(@Param("id") int id);

	@Transactional
	@Modifying // afficher les post avec nombre like desc
	@Query("SELECT p FROM Post p ORDER BY p.likes DESC")
	List<Post> getPostByHighLike();

	@Transactional
	@Modifying // afficher la post avec titre
	@Query("SELECT p FROM Post p WHERE p.title LIKE %:title%")
	List<Post> getPostByTitle(@Param("title") String title);

	@Transactional
	@Modifying
	@Query(value = "SELECT p.id,p.content,p.date, p.title, p.likes,p.dislikes, c.postcount FROM post as p INNER JOIN ( SELECT post_id, count(*) AS postcount FROM comment_post GROUP BY post_id ) as c on p.id = c.post_id Order by c.postcount DESC", nativeQuery = true)
	List<Post> getPostWithMaxComments();

}
