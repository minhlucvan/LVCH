package models;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.Entity;
import javax.persistence.Id;

import models.Thesis;
import models.UserAccount;

@Entity
public class Admin extends UserAccount{
	@Id
	public Long id;
	
	
	public Admin(){
		
	}
	
	public Admin(String email, String password){
		super(email, password, "Admin");
	}
	
	public static Admin authenticate(String email, String password) {
        return finder.where().eq("email", email)
                .eq("password", password).findUnique();
    }
	
	public static Finder<Long, Admin> finder =
            new Finder<Long, Admin>(Long.class, Admin.class);
}