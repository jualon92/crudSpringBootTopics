package com.example.demo2.course;

import javax.persistence.*;

import com.example.demo2.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String id;
	private String description;
	private String name;
	
	@ManyToOne
	private Topic topic; //course topic tied with course
	
	public Course() {}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id= id;
		this.name=name;
		this.description=description;
		this.topic = new Topic(topicId,"",""); //initial topic 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
