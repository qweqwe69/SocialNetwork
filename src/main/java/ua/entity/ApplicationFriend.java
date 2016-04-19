package ua.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ApplicationFriend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User appSender;
	
	@ManyToOne
	private User appRecipient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAppSender() {
		return appSender;
	}

	public void setAppSender(User appSender) {
		this.appSender = appSender;
	}

	public User getAppRecipient() {
		return appRecipient;
	}

	public void setAppRecipient(User appRecipient) {
		this.appRecipient = appRecipient;
	}
	
}
