package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.ReactEvents;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ReactEventsRepository;
@Service
public class ReactEventsServiceImpl  implements IReactEvents {
	
	@Autowired
	ReactEventsRepository ReactEventsRepository;

	@Override
	public List<ReactEvents> getAll() {
		return (List<ReactEvents>)this.ReactEventsRepository.Afficher();
	}

	@Override
	public List<Map<ReactEvents,User>> AfficherReactDetails(int keyword) {
		// TODO Auto-generated method stub
		return ReactEventsRepository.AfficherReactDetails(keyword);
	}
	
	public List <Map<ReactEvents,User>> getAllReacts (){
		return ReactEventsRepository.AfficherAll() ;
		
		
	}

	@Override
	public ReactEvents save(ReactEvents R) {
		// TODO Auto-generated method stub
		return this.ReactEventsRepository.save(R) ;
	}

	@Override
	public void SetInteresstedReact() {
		// TODO Auto-generated method stub
		ReactEventsRepository.SetInteresstedReact();
	}

	@Override
	public void SetParticipateReact() {
		// TODO Auto-generated method stub
		ReactEventsRepository.SetParticipateReact();
		
	}

	@Override
	public void SetNotInteresstedReact() {
		// TODO Auto-generated method stub
		ReactEventsRepository.SetNotInteresstedReact();
		
	}

	@Override
	public String getEmailbyReact(int keyword) {
		// TODO Auto-generated method stub
		return ReactEventsRepository.getEmailbyReact(keyword);
	}

	@Override
	public int getIduserByReact(int keyword) {
		// TODO Auto-generated method stub
		return ReactEventsRepository.getIduserByReact(keyword);
	}

}