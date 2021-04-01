package tn.esprit.spring.control;

import tn.esprit.spring.entity.*;

import tn.esprit.spring.service.ReactionService;

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
@RequestMapping("/api/reaction")
public class ReactionResource {

    private final Logger log = LoggerFactory.getLogger(ReactionResource.class);

    private static final String ENTITY_NAME = "reaction";

   

    private final ReactionService reactionService;

    public ReactionResource(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    
    @PostMapping("/reactions")
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction reaction) throws URISyntaxException {
        log.debug("REST request to save Reaction : {}", reaction);
        if (reaction.getId() != null) {
            throw new RuntimeException("A new reaction cannot already have an ID");
        }
        Reaction result = reactionService.save(reaction);
        return ResponseEntity.created(new URI("/api/reactions/" + result.getId()))
            .body(result);
    }

    
    @PutMapping("/reactions")
    public ResponseEntity<Reaction> updateReaction(@RequestBody Reaction reaction) throws URISyntaxException {
        log.debug("REST request to update Reaction : {}", reaction);
        if (reaction.getId() == null) {
            throw new RuntimeException("Invalid id");
        }
        Reaction result = reactionService.save(reaction);
        return ResponseEntity.ok()
            .body(result);
    }

    
    @GetMapping("/reactions")
    public List<Reaction> getAllReactions() {
        log.debug("REST request to get all Reactions");
        return reactionService.findAll();
    }

    
    @GetMapping("/reactions/{id}")
    public ResponseEntity<Reaction> getReaction(@PathVariable Long id) {
        log.debug("REST request to get Reaction : {}", id);
        Optional<Reaction> reaction = reactionService.findOne(id);
        return ResponseEntity.ok(reaction.orElse(null));
    }

    
    @DeleteMapping("/reactions/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        log.debug("REST request to delete Reaction : {}", id);
        reactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
