package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Role;
import ua.entity.User;
import ua.repository.CityRepository;
import ua.repository.FirstNameRepository;
import ua.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private FirstNameRepository firstNameRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}
	
	public void delete(int id){
		userRepository.delete(id);
	}
	
	public User findById(int userId){
		return userRepository.findOne(userId);
	}

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_ADMIN);
		userRepository.save(user);
	} 

}
