package ua.repository;

import org.springframework.data.repository.CrudRepository;

import ua.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
