package ua.repository;

import org.springframework.data.repository.CrudRepository;

import ua.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
