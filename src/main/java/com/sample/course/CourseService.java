package com.sample.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	List<Course> courseList = new ArrayList<>();

	public List<Course> getAllcourse(String topicId) {
		courseRepository.findByTopicId(topicId).forEach(x -> courseList.add(x));
		return courseList;
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void updateCourse(Course topic, String id) {
		courseRepository.save(topic);
	}

	public boolean delete(String id) {
		boolean isDeleted = courseList.removeIf(x -> x.getId().equals(id));
		return isDeleted;
	}

}
