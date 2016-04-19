package ua.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ApplicationFriend;
import ua.entity.User;
import ua.repository.ApplicationFriendRepository;
import ua.repository.UserRepository;

@Transactional
@Service
public class FriendService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicationFriendRepository applicationFriendRepository;
	
	
	public void addToFriend(int id){
		ApplicationFriend applicationFriend = applicationFriendRepository.findOne(id);
		User userRecipient = applicationFriend.getAppSender();
		User userSender = applicationFriend.getAppRecipient();
		userRecipient.getFriends().add(userSender);
		userSender.getFriends().add(userRecipient);
		userRepository.save(userSender);
		userRepository.save(userRecipient);
	}
	
	public List<User> showFriend(Principal principal){
		User user = userRepository.findOne((Integer.parseInt(principal.getName())));
		List<User> friends = user.getFriends();
		return friends;
	}
}
