package io.naztech.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring Framework Description"),
			new Topic("Java","Core Java","Core Java Description"),
			new Topic ("Javascript","Javascript","Javascript Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(Topic t : topics) {
			if(t.getId().equals(id)) {
				topics.set(topics.indexOf(t), topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
	


}
