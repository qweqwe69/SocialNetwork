package ua.repository;

import org.springframework.data.repository.CrudRepository;

import ua.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
