package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

public class PostForumFilter implements Serializable{
	private String title;
	private Instant minCreationDate;
	private Instant maxCreaionDate;
	public PostForumFilter() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instant getMinCreationDate() {
		return minCreationDate;
	}
	public void setMinCreationDate(Instant minCreationDate) {
		this.minCreationDate = minCreationDate;
	}
	public Instant getMaxCreaionDate() {
		return maxCreaionDate;
	}
	public void setMaxCreaionDate(Instant maxCreaionDate) {
		this.maxCreaionDate = maxCreaionDate;
	}
	
	
	
	
	
	
	
	
	

}
