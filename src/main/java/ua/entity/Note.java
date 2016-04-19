package ua.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Note {
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		List<Country> list = em.createQuery("select c from Country c where c.nameCounty = :country").setParameter("country", "USA").getResultList();
//		List<Country> cities = em.createQuery("select c from Country c join c.cities s where s.nameCity = :city").setParameter("city", "Lviv").getResultList();
//		List<Country> cities1 = em.createQuery("select c from Country c join c.cities s where s.nameCity = :city").setParameter("city", "New York").getResultList();
		
		City city0 = new City();
		City city1 = new City();
		City city2 = new City();
		City city3 = new City();
		City city4 = new City();
		
		city0.setNameCity("Lviv");
		city1.setNameCity("Ottawa");
		city2.setNameCity("Kyiv");
		city3.setNameCity("New York");
		city4.setNameCity("Warszawa");
		
		em.persist(city0);
		em.persist(city1);
		em.persist(city2);
		em.persist(city3);
		em.persist(city4);
		
		Country country0 = new Country();
		Country country1 = new Country();
		Country country2 = new Country();
		Country country3 = new Country();
		Country country4 = new Country();		
		
		country0.setNameCountry("Ukraine");
		country1.setNameCountry("Canada");
		country2.setNameCountry("New Zealand");
		country3.setNameCountry("USA");
		country4.setNameCountry("Poland");
		
		city0.setCountry(country0);
		city1.setCountry(country1);
		city2.setCountry(country2);
		city3.setCountry(country3);
		city4.setCountry(country4);
		
		em.persist(country0);
		em.persist(country1);
		em.persist(country2);
		em.persist(country3);
		em.persist(country4);
		
		FirstName firstname0 = new FirstName();
		FirstName firstname1 = new FirstName();
		FirstName firstname2 = new FirstName();
		FirstName firstname3 = new FirstName();
		FirstName firstname4 = new FirstName();
		
		firstname0.setNameUser("Yurii");
		firstname1.setNameUser("Abdul");
		firstname2.setNameUser("Eva");
		firstname3.setNameUser("Adolf");
		firstname4.setNameUser("Ivan");
		
		em.persist(firstname0);
		em.persist(firstname1);
		em.persist(firstname2);
		em.persist(firstname3);
		em.persist(firstname4);
		
//		ApplicationFriend applicationFriend0 = new ApplicationFriend();
//		ApplicationFriend applicationFriend1 = new ApplicationFriend();
//		ApplicationFriend applicationFriend2 = new ApplicationFriend();
//		ApplicationFriend applicationFriend3 = new ApplicationFriend();
//		ApplicationFriend applicationFriend4 = new ApplicationFriend();
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		user0.setEmail("qweqwe@hardcore.ru");
		user1.setEmail("abdulchyk@hardcore.ru");
		user2.setEmail("evushka@hardcore.ru");
		user3.setEmail("adya@hardcore.ru");
		user4.setEmail("vanya228@hardcore.ru");
		
		user0.setLastName("Balaushko");
		user1.setLastName("Alhazred");
		user2.setLastName("Braun");
		user3.setLastName("Hitler");
		user4.setLastName("Petrov");
		
		user0.setPassword("123456");
		user1.setPassword("654321");
		user2.setPassword("917382645");
		user3.setPassword("145236987");
		user4.setPassword("985632147");
		
		user0.setPhone("063-11-60-666");
		user1.setPhone("098-65-19-654");
		user2.setPhone("073-35-35-159");
		user3.setPhone("067-91-18-123");
		user4.setPhone("066-15-90-048");
		
		user0.setPlaceOfWork("qweqwe");
		user1.setPlaceOfWork("asdasd");
		user2.setPlaceOfWork("zxczxc");
		user3.setPlaceOfWork("rtyrty");
		user4.setPlaceOfWork("fghfgh");
		
		user0.setSex(Sex.MALE);
		user1.setSex(Sex.MALE);
		user2.setSex(Sex.FEMALE);
		user3.setSex(Sex.MALE);
		user4.setSex(Sex.MALE);
		
		user0.setCities(city0);
		user1.setCities(city1);
		user2.setCities(city2);
		user3.setCities(city3);
		user4.setCities(city4);
		
		user0.setFirstName(firstname0);
		user1.setFirstName(firstname1);
		user2.setFirstName(firstname2);
		user3.setFirstName(firstname3);
		user4.setFirstName(firstname4);
		
		em.persist(user0);
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		em.persist(user4);
		
		Message message0 = new Message();
		message0.setText("Lorem ipsum");
		message0.setRecipient(user0);
		message0.setRecipient(user3);
		
		Message message1 = new Message();
		message1.setText("dolor sit amet");
		message1.setRecipient(user1);
		message1.setSender(user2);
		
		Message message2 = new Message();
		message2.setText("consectetur adipiscing elit");
		message2.setRecipient(user2);
		message2.setSender(user1);
		
		Message message3 = new Message();
		message3.setText("sed do eiusmod tempor incididunt");
		message3.setRecipient(user3);
		message3.setSender(user4);
		
		Message message4 = new Message();
		message4.setText("ut labore et dolore magna aliqua");
		message4.setRecipient(user4);
		message4.setSender(user0);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
//		for(Country country : list){
//			System.out.println(country.getNameCounty());
//		}
		
//		for(Country country : cities){
//			System.out.println(country.getNameCounty());
//		}
//		
//		for(Country country1 : cities1){
//			System.out.println(country1.getNameCounty());
//		}
	}
}
