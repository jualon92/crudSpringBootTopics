package com.example.demo2.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository; // injects in var
	
	
	// private ArrayList<Course> courses = new ArrayList<>(Arrays.asList( new Course("spring1","springName","springDescr"),new Course("spring2", "springName2","springSecondDesc"))); 
	
 
	public ArrayList<Course> getAllCourses(String topicId){
		//para inicializar arraylist requiere una coleccion
		ArrayList <Course> courses = new ArrayList<>(); //ini arraylist
		courseRepository.findByTopicId(topicId).forEach( e -> courses.add(e)); 
		return courses;
	} 
	

	public void addCourse(Course newCourse) {
		courseRepository.save(newCourse);
	}
	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}
	public void deleteCourse(String id) {
		 courseRepository.deleteById(id);
	}
	
	public void updateCourse(Course newCourse) {
		courseRepository.save(newCourse); //repo knows if object with id exists, update. else insert
	}
	
	 
	
}
