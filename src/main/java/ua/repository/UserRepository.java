package ua.repository;

import org.springframework.data.repository.CrudRepository;

import ua.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByPhone(String login);
	
	User findByEmail(String login);
	
}
