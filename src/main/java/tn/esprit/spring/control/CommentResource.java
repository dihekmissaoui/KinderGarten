package tn.esprit.spring.control;

import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.service.CommentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    private final Logger log = LoggerFactory.getLogger(CommentResource.class);

    private static final String ENTITY_NAME = "comment";

   

    private final CommentService commentService;

    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }

    
    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) throws URISyntaxException {
        log.debug("REST request to save Comment : {}", comment);
        if (comment.getId() != null) {
            throw new RuntimeException("A new comment cannot already have an ID");
        }
        Comment result = commentService.save(comment);
        return ResponseEntity.created(new URI("/api/comments/" + result.getId()))
            .body(result);
    }

    
    @PutMapping("/comments")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) throws URISyntaxException {
        log.debug("REST request to update Comment : {}", comment);
        if (comment.getId() == null) {
            throw new RuntimeException("Invalid id");
        }
        Comment result = commentService.save(comment);
        return ResponseEntity.ok()
            .body(result);
    }

    
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        log.debug("REST request to get all Comments");
        return commentService.findAll();
    }

    
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        log.debug("REST request to get Comment : {}", id);
        Optional<Comment> comment = commentService.findOne(id);
        return ResponseEntity.ok(comment.orElse(null));
    }

   
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        log.debug("REST request to delete Comment : {}", id);
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
