package ua.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private City cities;

	@ManyToOne
	private FirstName firstName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "appSender")
	private List<ApplicationFriend> applicationFriendsSender;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "appRecipient")
	private List<ApplicationFriend> applicationFriendsRecipient;

	@Enumerated(EnumType.ORDINAL)
	private Sex sex;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sender")
	private List<Message> messageSenders;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipient")
	private List<Message> messageRecipients;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> friends;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private String placeOfWork;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public City getCities() {
		return cities;
	}

	public void setCities(City cities) {
		this.cities = cities;
	}

	public FirstName getFirstName() {
		return firstName;
	}

	public void setFirstName(FirstName firstName) {
		this.firstName = firstName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public List<Message> getMessageSenders() {
		return messageSenders;
	}

	public void setMessageSenders(List<Message> messageSenders) {
		this.messageSenders = messageSenders;
	}

	public List<Message> getMessageRecipients() {
		return messageRecipients;
	}

	public void setMessageRecipients(List<Message> messageRecipients) {
		this.messageRecipients = messageRecipients;
	}

	public List<ApplicationFriend> getApplicationFriendsSender() {
		return applicationFriendsSender;
	}

	public void setApplicationFriendsSender(
			List<ApplicationFriend> applicationFriendsSender) {
		this.applicationFriendsSender = applicationFriendsSender;
	}

	public List<ApplicationFriend> getApplicationFriendsRecipient() {
		return applicationFriendsRecipient;
	}

	public void setApplicationFriendsRecipient(
			List<ApplicationFriend> applicationFriendsRecipient) {
		this.applicationFriendsRecipient = applicationFriendsRecipient;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getLastName() {
		return lastName;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlaceOfWork() {
		return placeOfWork;
	}

	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	
}
