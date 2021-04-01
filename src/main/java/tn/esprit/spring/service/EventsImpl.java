package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CommentEvents;
import tn.esprit.spring.entity.CommentPost;
import tn.esprit.spring.entity.Events;
import tn.esprit.spring.repository.EventsRepository;

@Service
public class EventsImpl implements IEvents {
	@Autowired
	EventsRepository EventsRepository;

	@Override
	public List<Events> getAll() {
		return (List<Events>) this.EventsRepository.findAll();
	}
		@Override
	public Events save(Events e) {

		return this.EventsRepository.save(e);
	}
	@Override
	public Events saveE(Events e) {

		return this.EventsRepository.save(e);
	}


	@Override
	public void remove(int IdEvents) {
		this.EventsRepository.deleteById(IdEvents);

	}

	@Override
	public Optional<Events> getById(int IdEvents) {

		return this.EventsRepository.findById(IdEvents);
	}

	@Override
	public Events update(int IdEvents, Events Events) {

		Events updateevents = null;
		Optional<Events> ev = this.EventsRepository.findById(IdEvents);
		if (ev.isPresent()) {
			Events upevents = ev.get();
			upevents = Events;
			updateevents = this.EventsRepository.save(upevents);
		}
		return updateevents;
	}
	public List <Map<Events,Object>> search (String keyword){
		return EventsRepository.search(keyword);
		}
	@Override
	public List<Map<Events, Object>> ShowAllEvents() {
		// TODO Auto-generated method stub
		return EventsRepository.ShowAllEvents();
	}
	@Override
	public int getIduserByEvent(int keyword) {
		// TODO Auto-generated method stub
		return EventsRepository.getIduserByEvent(keyword);
	}
	
}
