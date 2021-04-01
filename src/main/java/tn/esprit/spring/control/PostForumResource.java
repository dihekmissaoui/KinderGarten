package tn.esprit.spring.control;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.query.PostForumQuery;
import tn.esprit.spring.service.PostForumService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/postforum")
public class PostForumResource {

    private final Logger log = LoggerFactory.getLogger(PostForumResource.class);

    private static final String ENTITY_NAME = "postForum";

    

    private final PostForumService postForumService;
    private final PostForumQuery postForumQuery;

    public PostForumResource(PostForumService postForumService,PostForumQuery postForumQuery ) {
        this.postForumService = postForumService;
        this.postForumQuery = postForumQuery;
    }

    
    @PostMapping("/post-forums")
    public ResponseEntity<PostForum> createPostForum(@RequestBody PostForum postForum) throws URISyntaxException {
        log.debug("REST request to save PostForum : {}", postForum);
        if (postForum.getId() != null) {
            throw new RuntimeException("A new postForum cannot already have an ID");
        }
        PostForum result = postForumService.save(postForum);
        return ResponseEntity.created(new URI("/api/post-forums/" + result.getId())).body(result);
    }

   
    @PutMapping("/post-forums")
    public ResponseEntity<PostForum> updatePostForum(@RequestBody PostForum postForum) throws URISyntaxException {
        log.debug("REST request to update PostForum : {}", postForum);
        if (postForum.getId() == null) {
            throw new RuntimeException("Invalid id");
        }
        PostForum result = postForumService.save(postForum);
        return ResponseEntity.ok()
            .body(result);
    }
    
   

   
    @GetMapping("/post-forums")
    public List<PostForum> getAllPostForums() {
        log.debug("REST request to get all PostForums");
        return postForumService.findAll();
    }

    
    @GetMapping("/post-forums/{id}")
    public ResponseEntity<PostForum> getPostForum(@PathVariable Long id) {
        log.debug("REST request to get PostForum : {}", id);
        Optional<PostForum> postForum = postForumService.findOne(id);
        return ResponseEntity.ok(postForum.orElse(null));
    }

    
    @DeleteMapping("/post-forums/{id}")
    public ResponseEntity<Void> deletePostForum(@PathVariable Long id) {
        log.debug("REST request to delete PostForum : {}", id);
        postForumService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/post-forums/filter")
    public ResponseEntity<Page<PostForum>> getFiltredPostForum(@RequestBody PostForumFilter postForumFilter, Pageable pageable){
        log.debug("REST request to get PostForumFilter : {}", postForumFilter);

    	
    	Page<PostForum> page = postForumQuery.findPostforumByFilter(postForumFilter, pageable);
		return new ResponseEntity<>(page,HttpStatus.OK);
    	
    }

}
