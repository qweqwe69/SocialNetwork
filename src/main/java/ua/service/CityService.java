package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.City;
import ua.repository.CityRepository;
import ua.repository.CountryRepository;


@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Iterable<City> getAll() {
		return cityRepository.findAll();
	}
	
	@Transactional
	public void save(String nameCity, int countryId) {
		City city = new City();
		city.setNameCity(nameCity);
		city.setCountry(countryRepository.findOne(countryId));
		cityRepository.save(city);
		
	}
	
	public void delete(int id){
		cityRepository.delete(id);
	}
	
	public City findOne(int id){
		return cityRepository.findOne(id);
	}
}

