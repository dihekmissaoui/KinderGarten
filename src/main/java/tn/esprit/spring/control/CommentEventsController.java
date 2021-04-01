package tn.esprit.spring.control;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.CommentPost;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ICommentEvents;
import tn.esprit.spring.service.IEvents;
import tn.esprit.spring.service.IUser;

@RestController
@RequestMapping("/api/commentevents")
public class CommentEventsController {
	
	@Autowired
	ICommentEvents commenteventsService;
	@Autowired
	IUser userservice ;
	@Autowired
	IEvents eventsservice ;
	
	@GetMapping("/")
	public List<CommentEvents> getAllCommentEvents() {
		return this.commenteventsService.getAll();
	}

	@GetMapping("/{comment-id}")
	@ResponseBody
	public Optional<CommentEvents> retrieveCommentEvents(@PathVariable("comment-id") int id) {
		return this. commenteventsService.getById(id);
	}
	
	@PostMapping("/")
	@ResponseBody
	public CommentEvents addCommentEvent(@RequestBody CommentEvents CommentEvent) {
		CommentEvents comment = commenteventsService.save(CommentEvent);
		return comment;
	}
	@Transactional
	@PostMapping("/Add")
	@ResponseBody
	public List<Map<CommentEvents, User>> AddComment(@RequestBody CommentEvents com ) {
		CommentEvents comment = commenteventsService.save(com);
		int idE = commenteventsService.getIdEventByC(com.getIdCommentEvents());
		System.out.println("IDDEventtttttttttttttt"+idE);
		int idD = eventsservice.getIduserByEvent(idE);
		System.out.println("DIRECTRORRRRRRRRRRRRRR"+idD);
		userservice.SetNotifEvents(idD);
		return commenteventsService.AfficherAllComments();
	}

	@PutMapping("/ShowComNotif/{keyword}")
	@ResponseBody
	public List <Map<CommentEvents,User>> getComByD (@PathVariable("keyword") int keyword) {
		userservice.SetNotifisRead(keyword);
		return commenteventsService.getComByD(keyword);
	}
	
	// supprimer post
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeCommentEvents(@PathVariable("id") int id) {
		commenteventsService.remove(id);
	}

	// mis a jour post
	@PutMapping("/{id}")
	@ResponseBody
	public CommentEvents modifyCommentEvents(@PathVariable int id, @RequestBody CommentEvents CommentEvent) {
		return commenteventsService.updatecommnentEvents(id, CommentEvent);
	}
	
	@GetMapping("/All")
	@ResponseBody
	public List<Map<CommentEvents, User>> AfficherAllComments(){
		return commenteventsService.AfficherAllComments();
		
	}

	@GetMapping("/Details/{keyword}")
	@ResponseBody
	public  List<Map<CommentEvents, User>> AfficherEventsComments(@PathVariable("keyword") int keyword){
		return commenteventsService.AfficherEventsComments(keyword) ;
		
	}
	
}
