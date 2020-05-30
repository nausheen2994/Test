package com.sample.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.topics.Topic;
import com.sample.topics.TopicService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	TopicService topicService;

	@RequestMapping("/topics/{topicId}/course")
	public List<Course> getAllCourses(@PathVariable String topicId) {

		return courseService.getAllcourse(topicId);

	}

	@RequestMapping("/topics/{topicId}/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
	public void createCourse(@RequestBody Course course,@PathVariable String topicId) {
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/course/{id}")
	public void  updateCourse(@RequestBody Course course,@PathVariable String id) {
		 courseService.updateCourse(course,id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE ,value="/topics/{topicId}/course/{id}")
	public boolean deleteCourse(@ PathVariable String id) {
		return courseService.delete(id);
		
	}

}
