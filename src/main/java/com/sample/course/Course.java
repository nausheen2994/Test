package com.sample.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sample.topics.Topic;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	Topic topic;
	
	public Course() {
		
	}
	public String getId() {
		return id;
	}
	public Course(String id, String name, String description,Topic topic) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=topic;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
