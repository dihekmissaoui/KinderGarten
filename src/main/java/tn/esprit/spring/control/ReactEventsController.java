package tn.esprit.spring.control;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.mail.SimpleMailMessage;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.EmailSenderService;
import tn.esprit.spring.service.IEvents;
import tn.esprit.spring.service.IReactEvents;
import tn.esprit.spring.service.IUser;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/ReactEvents")
public class ReactEventsController {

	@Autowired
	IReactEvents reactsService ;
	@Autowired
	IEvents EventsService;
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
	IUser userservice;
    
    
	@GetMapping("/")
	public List<ReactEvents> getAllReactEvents() {
		return (List<ReactEvents>) this.reactsService.getAll();
	}
	@GetMapping("/Details/{keyword}")
	@ResponseBody
	public List <Map<ReactEvents,User>> AfficherReactDetails(@PathVariable("keyword") int keyword){
		return reactsService.AfficherReactDetails(keyword);
		
	}
	@GetMapping("/All")
	@ResponseBody
	public List <Map<ReactEvents,User>> getAllReacts(){
		return reactsService.getAllReacts();
		
	}
	
	@PostMapping("/AddReact")
	@ResponseBody
	public List<Map<Events, Object>>  addReact(@RequestBody ReactEvents R) {
		
		ReactEvents react = reactsService.save(R);
		int idUser = reactsService.getIduserByReact(R.getIdReact());
		System.out.println("iduserrrrrrrrrrrrrr"+idUser);
		String adress = userservice.findEmailByID(idUser);
		System.out.println("adressssssssssss"+adress);
		//User user = userservice.findUserByEmail(adress);
		if(R.getReact().equals("PARTICIPATE")){
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		//mailMessage.setTLS(true);
		mailMessage.setTo(adress);
    	mailMessage.setSubject("Events!!");
    	mailMessage.setFrom("fatma.chakroun@esprit.tn");
    	mailMessage.setText("Merci pour votre participation");
    	emailSenderService.sendEmail(mailMessage);
		}
    	//return react;
		reactsService.SetInteresstedReact();
		reactsService.SetParticipateReact();
		reactsService.SetNotInteresstedReact();
		return EventsService.ShowAllEvents();
		
	}
	
	@PutMapping("/SetReact")
	@ResponseBody
	public List<Map<Events, Object>> SetReact(){
		reactsService.SetInteresstedReact();
		reactsService.SetParticipateReact();
		reactsService.SetNotInteresstedReact();
		return EventsService.ShowAllEvents();
	}

}
