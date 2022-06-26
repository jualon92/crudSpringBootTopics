package com.example.demo2.course;
 
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 
public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByName(String name);

	public List<Course> findByDescription(String name); //run a filter with p filter. works w strings
	
	public List<Course> findByTopicId(String topicId); //topic property on course => id property of it
	
}