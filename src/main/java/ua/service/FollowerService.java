package ua.service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ApplicationFriend;
import ua.entity.User;
import ua.repository.UserRepository;

@Service
public class FollowerService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<ApplicationFriend> showFollowers(Principal principal){
		if(principal == null )return Collections.emptyList();
		User user = userRepository.findOne((Integer.parseInt(principal.getName())));
		Hibernate.initialize(user.getApplicationFriendsRecipient());
		List<ApplicationFriend> appFriends = user.getApplicationFriendsRecipient();
		return appFriends;
	}
}
