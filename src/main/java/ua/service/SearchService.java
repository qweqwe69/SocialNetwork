package ua.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.ApplicationFriend;
import ua.repository.ApplicationFriendRepository;
import ua.repository.UserRepository;

@Service
public class SearchService {
	
	@Autowired
	private ApplicationFriendRepository applicationFriendRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void addAppFriend(int id, Principal principal){
		ApplicationFriend applicationFriend = new ApplicationFriend();
		applicationFriend.setAppSender(userRepository.findOne(Integer.parseInt(principal.getName())));
		applicationFriend.setAppRecipient(userRepository.findOne(id));
		applicationFriendRepository.save(applicationFriend);
	}
}
