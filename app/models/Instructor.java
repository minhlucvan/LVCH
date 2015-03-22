package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import models.Learner;
import models.Thesis;
import models.UserAccount;

@Entity
public class Instructor extends UserAccount{
	@Id
	public Long id;
	
	@OneToOne
	Thesis thesis;
	
	String facilty;
	
	public Instructor(){
		this.role = "Instructor";
	}
	
	public Instructor(String email, String password){
		super(email, password, "Instructor");
	}
	
	public static Instructor authenticate(String email, String password) {
        return finder.where().eq("email", email)
                .eq("password", password).findUnique();
    }
	
	public static Finder<Long, Instructor> finder =
            new Finder<Long, Instructor>(Long.class, Instructor.class);
}