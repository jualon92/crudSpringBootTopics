package com.example.demo2.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.topic.Topic;

@RestController
public class CourseController { //object to get, put etc.  id type
	 
	@Autowired
	private CourseService courseService;

	
	@RequestMapping("/topics/{id}/courses") //gets all courses of certain topic
	public ArrayList<Course> getCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}") //gets a course matching p id
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));  // set parameter as  new topic Id 
		courseService.addCourse(course);
	}
	 
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicsId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId,  @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));  // set parameter as  new topic Id 
		courseService.updateCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicsId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	
 
	 
	
}

 
