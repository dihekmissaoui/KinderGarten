package tn.esprit.spring.control;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.CommentPost;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IEvents;
import tn.esprit.spring.service.IUser;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/Events")
public class EventsController {
	@Autowired
	IEvents EventsService;
	@Autowired
	IUser userImp;
	@Autowired
	UserRepository userRepos;
	@GetMapping("/")
	public List<Events> getAllEvents() {
		return this.EventsService.getAll();
	}
	
	@GetMapping("/{IdEvents}")
	@ResponseBody
	public Optional<Events> getEventsById(@PathVariable("IdEvents") int IdEvents) {
		return this.EventsService.getById(IdEvents);
	}


	@PostMapping("/")
	@ResponseBody 
	public Events AddEvents (@RequestBody Events Events) {
		Events events = EventsService.save(Events);
		return events;
	}

	@PostMapping("/AddByDirector/{iduser}")
	@ResponseBody 
	public Events AddEventsDirector (@PathVariable("iduser") int iduser ,@Validated @RequestBody Events Events) {
			if(userImp.getDirectorByIdE(iduser).isEmpty())
			{
				return null;
				
			}
			else
			{
				Events events = EventsService.save(Events);
				return events;
			}
	}

	@DeleteMapping("/{IdEvents}")
	@ResponseBody
	public void RemoveEvents(@PathVariable("IdEvents") int IdEvents) {
		EventsService.remove(IdEvents);
	}

	@PutMapping("/{IdEvents}")
	@ResponseBody
	public Events UpdateEvents(@PathVariable int IdEvents, @RequestBody Events Events) {
		return EventsService.update(IdEvents , Events);
	}
	
	@GetMapping("/search/{keyword}")
	@ResponseBody
	public List <Map<Events,Object>> search(@PathVariable("keyword") String keyword){
		return EventsService.search(keyword) ;
		
	}
	
	@GetMapping("/ShowAllEvents")
	@ResponseBody
	public List<Map<Events, Object>> ShowAllEvents() {
		return EventsService.ShowAllEvents() ;
		
	}
	
	
}
