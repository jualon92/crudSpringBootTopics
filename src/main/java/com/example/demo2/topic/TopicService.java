package com.example.demo2.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository; // injects in var
	
	
	 private ArrayList<Topic> topics = new ArrayList<>(Arrays.asList( new Topic("spring1","springName","springDescr"),new Topic("spring2", "springName2","springSecondDesc"))); 
	
 
	public ArrayList<Topic> getAllTopics(){
		//para inicializar arraylist requiere una coleccion
		ArrayList <Topic> topics = new ArrayList<>(); //ini arraylist
		topicRepository.findAll().forEach( e -> topics.add(e)); 
		return topics;
	} 
	

	public void addTopic(Topic nuevoTopic) {
		topicRepository.save(nuevoTopic);
	}
	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}
	public void deleteTopic(String id) {
		 topicRepository.deleteById(id);
	}
	
	public void updateTopic(String id, Topic nuevoTopic) {
		topicRepository.save(nuevoTopic); //repo knows if object with id exists, update. else insert
	}
	
	 
	
}
