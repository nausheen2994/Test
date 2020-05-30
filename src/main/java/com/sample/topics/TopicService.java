package com.sample.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;

	List<Topic> topicList = new ArrayList<>();

	public List<Topic> getAllTopic() {
		
		topicRepository.findAll().forEach(x->topicList.add(x));
		return topicList;
	}
	
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic){
             topicRepository.save(topic);
	}


	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}


	public boolean delete(String id) {
		boolean  isDeleted= topicList.removeIf(x->x.getId().equals(id));
		return isDeleted;
			}


}
