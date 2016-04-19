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
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FirstNameRepository firstNameRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Iterable<User> getAll() {
		return userRepository.findAll();
	}
	
//	@Transactional
//	public void save(String lastName, String email, String password, 
//			String phone, String placeOfWork, int cityId, 
//			int firstnameId, String sex, String role) {
//		User user = new User();
//		user.setLastName(lastName);
//		user.setEmail(email);
//		user.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setPhone(phone);
//		user.setPlaceOfWork(placeOfWork);
//		user.setCities(cityRepository.findOne(cityId));
//		user.setFirstName(firstNameRepository.findOne(firstnameId));
//		user.setSex(Sex.valueOf(sex.toUpperCase()));
//		if(role == null){
//			user.setRole(Role.ROLE_USER);
//			userRepository.save(user);
//		}else {
//			user.setRole(Role.valueOf(role.toUpperCase()));
//			userRepository.save(user);
//		}
//		
//	}
	
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if(user.getRole() == null){
			user.setRole(Role.ROLE_USER);
		}
		userRepository.save(user);
	} 
}
