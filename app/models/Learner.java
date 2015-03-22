package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import models.Thesis;
import models.Instructor;
import models.UserAccount;

@Entity
public class Learner extends UserAccount{
	@Id
	public Long id;
	
	@OneToOne   
	Thesis thesis;

	
	String facilty; //class facility
	String Class; //class class
	
	public Learner(){
		this.role = "Learner";
	}
	
	public Learner(String email, String password){
		super(email, password, "Learner");
	}
	
	public static Learner authenticate(String email, String password) {
        return finder.where().eq("email", email)
                .eq("password", password).findUnique();
    }
	
	public static Finder<Long, Learner> finder =
            new Finder<Long, Learner>(Long.class, Learner.class);
	
}
